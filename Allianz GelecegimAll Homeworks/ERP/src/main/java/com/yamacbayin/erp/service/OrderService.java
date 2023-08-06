package com.yamacbayin.erp.service;

import com.yamacbayin.erp.database.entity.*;
import com.yamacbayin.erp.database.repository.CustomerRepository;
import com.yamacbayin.erp.database.repository.OrderRepository;
import com.yamacbayin.erp.database.repository.ProductRepository;
import com.yamacbayin.erp.model.dto.NewOrderDTO;
import com.yamacbayin.erp.model.dto.OrderItemDTO;
import com.yamacbayin.erp.model.OrderStatusEnum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class for managing orders, including creation, retrieval, and updates.
 */
@Service
public class OrderService implements IService<OrderEntity, NewOrderDTO> {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final InvoiceGeneratorService invoiceGeneratorService;

    /**
     * Constructor to initialize the OrderService.
     *
     * @param customerRepository      The repository for accessing customer data.
     * @param productRepository       The repository for accessing product data.
     * @param orderRepository         The repository for accessing order data.
     * @param invoiceGeneratorService The service for generating invoices.
     */
    @Autowired
    public OrderService(CustomerRepository customerRepository,
                        ProductRepository productRepository,
                        OrderRepository orderRepository,
                        InvoiceGeneratorService invoiceGeneratorService) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.invoiceGeneratorService = invoiceGeneratorService;
    }

    /**
     * Creates a new order based on the provided DTO.
     *
     * @param newOrderDTO The DTO containing the order details.
     * @return The created order entity.
     */
    @Override
    public OrderEntity create(NewOrderDTO newOrderDTO) {
        // Retrieve the customer based on the provided UUID
        Optional<CustomerEntity> customerOptional = customerRepository.findByUuid(newOrderDTO.getCustomerUUID());

        if (customerOptional.isEmpty()) {
            // Customer not found, unable to create the order
            return null;
        }

        // Initialize a new order entity
        OrderEntity order = new OrderEntity();
        order.setOrderProducts(new ArrayList<>());
        order.setOrderStatus(OrderStatusEnum.AWAITING_CONFIRMATION);
        order.setCustomerEntity(customerOptional.get());

        boolean cancelOrder = false;

        // Iterate through the order items in the DTO and add them to the order entity
        for (OrderItemDTO itemDTO : newOrderDTO.getItems()) {
            // Retrieve the product based on the provided product ID
            Optional<ProductEntity> productOptional = productRepository.findById(itemDTO.getProductId());

            // Check if the product exists
            if (productOptional.isEmpty()) {
                // Invalid product added to the order, mark for cancellation
                cancelOrder = true;
            }

            ProductEntity product = productOptional.get();
            OrderProductEntity orderProduct = new OrderProductEntity();
            orderProduct.setOrderEntity(order);
            orderProduct.setName(product.getName());
            orderProduct.setProductEntity(product);
            orderProduct.setQuantity(itemDTO.getQuantity());

            // Check if there is enough stock for the product or if the quantity is zero
            if (product.getStockQuantity() < orderProduct.getQuantity() || orderProduct.getQuantity() == 0) {
                // Not enough quantity, mark for cancellation
                cancelOrder = true;
            }

            orderProduct.setPriceAtTime(product.getPrice());
            orderProduct.setIsTaxIncluded(product.getIsTaxIncluded());

            order.getOrderProducts().add(orderProduct);
        }

        // If no valid products are added to the order, do not persist and return null
        if (order.getOrderProducts().isEmpty()) {
            return null;
        }

        // If there are invalid products or quantities, persist the order as cancelled
        if (cancelOrder) {
            order.setOrderStatus(OrderStatusEnum.CANCELLED);
        }

        // Save and return the created order entity
        return orderRepository.save(order);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity findByUuid(UUID uuid) {
        Optional<OrderEntity> order = orderRepository.findByUuid(uuid);
        return order.orElse(null);
    }

    @Override
    public OrderEntity updateByUuid(UUID uuid, OrderEntity orderEntity) {
        // Find the original order entity by UUID
        OrderEntity dbOrder = findByUuid(uuid);

        if (dbOrder != null) {
            // Update the customer, products, and invoice of the original order with the new details
            dbOrder.setCustomerEntity(orderEntity.getCustomerEntity());
            dbOrder.setOrderProducts(orderEntity.getOrderProducts());
            dbOrder.setInvoice(dbOrder.getInvoice());

            // Check if the order status has changed to confirmed and whether it was awaiting confirmation
            boolean newlyConfirmedOrder = dbOrder.getOrderStatus() == OrderStatusEnum.AWAITING_CONFIRMATION
                    && orderEntity.getOrderStatus() == OrderStatusEnum.CONFIRMED;
            // Update the order status with the new status
            dbOrder.setOrderStatus(orderEntity.getOrderStatus());

            // Validate the products in the updated order
            boolean areProductsValid = validateProducts(dbOrder);

            if (areProductsValid) {
                // If the order is confirmed and there is no existing invoice, generate a new invoice
                if (newlyConfirmedOrder && orderEntity.getInvoice() == null) {
                    InvoiceEntity invoice = invoiceGeneratorService.generateInvoice(dbOrder);
                    dbOrder.setInvoice(invoice);
                }
            } else {
                // Invalid products, cancel the order
                dbOrder.setOrderStatus(OrderStatusEnum.CANCELLED);
            }

            // Save and return the updated order entity
            return orderRepository.save(dbOrder);
        }

        // Return null if the original order is not found
        return null;
    }

    /**
     * Updates the status of an order by its UUID.
     *
     * @param uuid   The UUID of the order to update.
     * @param status The new status to set for the order.
     * @return The updated order entity, or null if the order was not found or the status is invalid.
     */
    @Transactional
    public OrderEntity updateStatusByUuid(UUID uuid, Integer status) {
        OrderStatusEnum newStatusEnum = OrderStatusEnum.fromValue(status);

        //invalid status
        if (newStatusEnum == null) {
            return null;
        }

        Optional<OrderEntity> orderEntityOptional = orderRepository.findByUuid(uuid);
        //return null if the uuid is not valid or the new status equals to the old status
        if (orderEntityOptional.isEmpty() || (orderEntityOptional.get().getOrderStatus() == newStatusEnum)) {
            return null;
        } else {
            OrderEntity dbOrderEntity = orderEntityOptional.get();


            boolean newlyConfirmedOrder = dbOrderEntity.getOrderStatus() == OrderStatusEnum.AWAITING_CONFIRMATION
                    && newStatusEnum == OrderStatusEnum.CONFIRMED;

            if (newlyConfirmedOrder) {
                //newly confirmed order, validate the order products
                boolean areProductsValid = validateProducts(dbOrderEntity);
                if (areProductsValid) {
                    //products are valid, generate the invoice
                    dbOrderEntity.setOrderStatus(newStatusEnum);
                    InvoiceEntity invoice = invoiceGeneratorService.generateInvoice(dbOrderEntity);
                    dbOrderEntity.setInvoice(invoice);
                } else {
                    //invalid products, cancel the order
                    dbOrderEntity.setOrderStatus(OrderStatusEnum.CANCELLED);
                }
            } else {
                dbOrderEntity.setOrderStatus(newStatusEnum);
            }

            return orderRepository.save(dbOrderEntity);
        }
    }

    @Override
    public Boolean deleteByUuid(UUID uuid) {
        OrderEntity order = findByUuid(uuid);

        if (order != null) {
            orderRepository.deleteByUuid(uuid);
            return true;
        }

        return false;
    }

    // Private method to validate product stocks and quantities
    private boolean validateProducts(OrderEntity orderEntity) {
        //validate product stocks
        for (OrderProductEntity orderProduct : orderEntity.getOrderProducts()) {
            Optional<ProductEntity> productOptional = productRepository
                    .findById(orderProduct.getProductEntity().getId());

            //invalid product
            if (productOptional.isEmpty()) {
                return false;
            } else {
                //not enough stock
                if (orderProduct.getQuantity() > productOptional.get().getStockQuantity()) {
                    return false;
                }
            }
        }

        return true;
    }

}
