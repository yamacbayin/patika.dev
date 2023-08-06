package com.yamacbayin.erp.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yamacbayin.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@AttributeOverride(name = "uuid", column = @Column(name = "product_uuid"))
@Data
public class ProductEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer stockQuantity;
    @Column(nullable = false)
    private Boolean isTaxIncluded;

    @OneToMany(mappedBy = "productEntity")
    @JsonIgnore
    private List<OrderProductEntity> orderProducts;

}
