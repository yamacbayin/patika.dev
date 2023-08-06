package com.yamacbayin.erp.model.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class NewOrderDTO {
    private UUID customerUUID;
    private List<OrderItemDTO> items;
}
