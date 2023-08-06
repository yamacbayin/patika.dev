package com.yamacbayin.erp.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewProductDTO {
    private String name;
    private BigDecimal price;
    private Integer stockQuantity;
    private Boolean isTaxIncluded;
}
