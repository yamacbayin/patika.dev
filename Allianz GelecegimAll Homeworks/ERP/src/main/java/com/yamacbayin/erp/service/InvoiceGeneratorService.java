package com.yamacbayin.erp.service;

import com.yamacbayin.erp.database.entity.InvoiceEntity;
import com.yamacbayin.erp.database.entity.OrderEntity;
import com.yamacbayin.erp.database.entity.OrderProductEntity;
import com.yamacbayin.erp.database.entity.ProductEntity;
import com.yamacbayin.erp.database.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * Service responsible for generating invoices based on orders and products.
 */
@Service
public class InvoiceGeneratorService {

    private String taxKey;
    private int taxRate;
    private final ProductRepository productRepository;

    /**
     * Constructor to initialize the InvoiceGeneratorService.
     *
     * @param productRepository The repository for accessing product data.
     * @param settingsService   The service for retrieving settings data.
     * @param taxKey            The key used to retrieve tax rate from settings.
     */
    @Autowired
    public InvoiceGeneratorService(ProductRepository productRepository,
                                   SettingsService settingsService,
                                   @Value("${tax.key}") String taxKey) {
        this.productRepository = productRepository;
        this.taxKey = taxKey;
        taxRate = settingsService.getSettingsMap().get(taxKey);
    }

    /**
     * Generates an invoice for the given order.
     *
     * @param orderEntity The order for which the invoice needs to be generated.
     * @return The generated invoice entity.
     */
    public InvoiceEntity generateInvoice(OrderEntity orderEntity) {

        double taxAsFraction = (double) taxRate / 100;

        BigDecimal totalAmountWithoutTax = BigDecimal.ZERO;
        BigDecimal totalTaxAmount = BigDecimal.ZERO;

        for (OrderProductEntity orderProduct : orderEntity.getOrderProducts()) {

            // Get product from the database and decrease quantity
            Optional<ProductEntity> productEntityOptional = productRepository
                    .findById(orderProduct.getProductEntity().getId());
            ProductEntity product = productEntityOptional.get();
            product.setStockQuantity(product.getStockQuantity() - orderProduct.getQuantity());
            productRepository.save(product);

            // Calculate product and tax amounts based on tax inclusion
            BigDecimal productTotal;
            BigDecimal taxTotal;

            if (orderProduct.getIsTaxIncluded()) {
                BigDecimal allAmount = orderProduct.getPriceAtTime().multiply(new BigDecimal(orderProduct.getQuantity()));

                productTotal = allAmount.multiply(BigDecimal.valueOf(100).setScale(2))
                        .divide(BigDecimal.valueOf(taxRate + 100), 2, RoundingMode.HALF_UP);

                taxTotal = allAmount.subtract(productTotal).setScale(2, RoundingMode.HALF_UP);
            } else {
                BigDecimal productPrice = orderProduct.getPriceAtTime();
                BigDecimal taxPrice = productPrice.multiply(new BigDecimal(taxAsFraction)).setScale(2, RoundingMode.HALF_UP);

                productTotal = productPrice.multiply(BigDecimal.valueOf(orderProduct.getQuantity()));
                taxTotal = taxPrice.multiply(BigDecimal.valueOf(orderProduct.getQuantity()));
            }

            totalAmountWithoutTax = totalAmountWithoutTax.add(productTotal);
            totalTaxAmount = totalTaxAmount.add(taxTotal);
        }

        BigDecimal totalAmount = totalAmountWithoutTax.add(totalTaxAmount);

        // Create and populate the invoice entity
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setOrder(orderEntity);
        invoiceEntity.setTotalAmountWithoutTax(totalAmountWithoutTax);
        invoiceEntity.setTotalTaxAmount(totalTaxAmount);
        invoiceEntity.setTotalAmount(totalAmount);

        return invoiceEntity;
    }
}
