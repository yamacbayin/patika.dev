package com.yamacbayin.erp.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yamacbayin.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "customers")
@AttributeOverride(name = "uuid", column = @Column(name = "customer_uuid"))
@Data
public class CustomerEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column
    private String address;

    @OneToMany(mappedBy = "customerEntity")
    @JsonIgnore
    private List<OrderEntity> orders;
}
