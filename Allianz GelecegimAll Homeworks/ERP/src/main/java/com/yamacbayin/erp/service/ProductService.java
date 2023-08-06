package com.yamacbayin.erp.service;

import com.yamacbayin.erp.database.entity.ProductEntity;
import com.yamacbayin.erp.database.repository.ProductRepository;
import com.yamacbayin.erp.model.dto.NewProductDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements IService<ProductEntity, NewProductDTO> {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity create(NewProductDTO newProductDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(newProductDTO.getName());
        productEntity.setStockQuantity(newProductDTO.getStockQuantity());
        productEntity.setPrice(newProductDTO.getPrice());
        productEntity.setIsTaxIncluded(newProductDTO.getIsTaxIncluded());
        return productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity findByUuid(UUID uuid) {
        Optional<ProductEntity> optional = productRepository.findByUuid(uuid);
        return optional.orElse(null);
    }

    @Override
    public ProductEntity updateByUuid(UUID uuid, ProductEntity productEntity) {
        ProductEntity product = findByUuid(uuid);

        if (product != null) {
            product.setName(productEntity.getName());
            product.setStockQuantity(product.getStockQuantity());
            product.setPrice(productEntity.getPrice());
            product.setIsTaxIncluded(productEntity.getIsTaxIncluded());

            return productRepository.save(product);
        }

        return null;
    }

    /**
     * Updates the price of a product with the specified UUID.
     *
     * @param uuid     The UUID of the product to update.
     * @param newPrice The new price to set for the product.
     * @return The updated product entity, or null if the product with the given UUID is not found.
     */
    @Transactional
    public ProductEntity updatePriceByUuid(UUID uuid, BigDecimal newPrice) {
        ProductEntity product = findByUuid(uuid);

        if (product != null) {
            product.setPrice(newPrice);
            return productRepository.save(product);
        }
        // Return null if the product with the given UUID is not found
        return null;
    }

    /**
     * Updates the stock quantity of a product with the specified UUID.
     *
     * @param uuid     The UUID of the product to update.
     * @param quantity The new stock quantity to set for the product.
     * @return The updated product entity, or null if the product with the given UUID is not found.
     */
    @Transactional
    public ProductEntity updateQuantityByUuid(UUID uuid, Integer quantity) {
        ProductEntity product = findByUuid(uuid);

        if (product != null) {
            product.setStockQuantity(quantity);
            return productRepository.save(product);
        }
        // Return null if the product with the given UUID is not found
        return null;
    }

    @Override
    public Boolean deleteByUuid(UUID uuid) {
        ProductEntity product = findByUuid(uuid);

        if (product != null) {
            productRepository.deleteByUuid(uuid);
            return true;
        }
        return false;
    }
}
