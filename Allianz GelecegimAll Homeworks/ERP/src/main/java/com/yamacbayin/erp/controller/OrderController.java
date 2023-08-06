package com.yamacbayin.erp.controller;

import com.yamacbayin.erp.database.entity.OrderEntity;
import com.yamacbayin.erp.model.dto.NewOrderDTO;
import com.yamacbayin.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderEntity> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrderEntity> findByUuid(@PathVariable UUID uuid) {
        OrderEntity orderEntity = orderService.findByUuid(uuid);
        if (orderEntity != null) {
            return new ResponseEntity<>(orderEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody NewOrderDTO newOrderDTO) {
        OrderEntity createdOrder = orderService.create(newOrderDTO);
        if (orderService != null) {
            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable UUID uuid, @RequestBody OrderEntity orderEntity) {
        OrderEntity order = orderService.updateByUuid(uuid, orderEntity);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{uuid}/status:{status}")
    public ResponseEntity<OrderEntity> updateStatusByUuid(@PathVariable UUID uuid, @PathVariable Integer status) {
        OrderEntity order = orderService.updateStatusByUuid(uuid, status);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable UUID uuid) {
        Boolean isDeleted = orderService.deleteByUuid(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }


}
