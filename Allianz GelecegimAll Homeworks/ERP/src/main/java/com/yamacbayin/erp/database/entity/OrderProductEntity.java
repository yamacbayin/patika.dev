package com.yamacbayin.erp.database.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yamacbayin.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Represents a snapshot of a product at the time an order is placed.
 * This entity stores details about a product included in an order,
 * such as its name, price at the time of order, quantity, and tax status.
 * It establishes a relationship between an order and the products it contains.
 *
 * <p>The {@link OrderProductEntity} class allows the application to store
 * historical information about a product's state when an order is created.
 * This can be useful for tracking pricing changes over time and enabling
 * the retrieval of a product's order history.
 *
 * <p>The entity is associated with an {@link OrderEntity} to capture the order
 * it belongs to, as well as a {@link ProductEntity} to reference the specific product.
 *
 * <p>Furthermore, this entity can be extended to support additional features,
 * such as querying a product's order history to view all orders in which the
 * product has been included. This can provide insights into the popularity and
 * demand for the product over time.
 *
 * @see OrderEntity
 * @see ProductEntity
 */
@Entity
@Table(name = "order_products")
@AttributeOverride(name = "uuid", column = @Column(name = "order_product_uuid"))
@Data
public class OrderProductEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductEntity productEntity;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal priceAtTime;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Boolean isTaxIncluded;

}
