package com.yamacbayin.erp.controller;

import com.yamacbayin.erp.database.entity.ProductEntity;
import com.yamacbayin.erp.model.dto.NewProductDTO;
import com.yamacbayin.erp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductEntity> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ProductEntity> findByUuid(@PathVariable UUID uuid) {
        ProductEntity product = productService.findByUuid(uuid);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody NewProductDTO newProductDTO) {
        ProductEntity product = productService.create(newProductDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable UUID uuid,
                                                       @RequestBody ProductEntity productEntity) {
        ProductEntity updatedProduct = productService.updateByUuid(uuid, productEntity);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{uuid}/price:{price}")
    public ResponseEntity<ProductEntity> updateProductPrice(@PathVariable UUID uuid,
                                                            @PathVariable BigDecimal price) {
        ProductEntity updatedProduct = productService.updatePriceByUuid(uuid, price);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{uuid}/quantity:{quantity}")
    public ResponseEntity<ProductEntity> updateProductQuantity(@PathVariable UUID uuid,
                                                               @PathVariable Integer quantity) {
        ProductEntity updatedProduct = productService.updateQuantityByUuid(uuid, quantity);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable UUID uuid) {
        Boolean isDeleted = productService.deleteByUuid(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

}
