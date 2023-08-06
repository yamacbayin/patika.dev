package com.yamacbayin.erp.database.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yamacbayin.erp.model.OrderStatusEnum;
import com.yamacbayin.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "orders")
@AttributeOverride(name = "uuid", column = @Column(name = "order_uuid"))
@Data
public class OrderEntity extends BaseEntity {

    private OrderStatusEnum orderStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<OrderProductEntity> orderProducts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    @JsonManagedReference
    private InvoiceEntity invoice;


}
