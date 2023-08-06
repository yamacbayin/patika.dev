package com.yamacbayin.erp.database.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yamacbayin.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "invoices")
@AttributeOverride(name = "uuid", column = @Column(name = "invoice_uuid"))
@Data
public class InvoiceEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private OrderEntity order;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmountWithoutTax;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalTaxAmount;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

}
