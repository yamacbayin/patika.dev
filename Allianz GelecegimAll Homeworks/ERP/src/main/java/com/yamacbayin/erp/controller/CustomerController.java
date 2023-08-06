package com.yamacbayin.erp.controller;

import com.yamacbayin.erp.database.entity.CustomerEntity;
import com.yamacbayin.erp.model.dto.NewCustomerDTO;
import com.yamacbayin.erp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerEntity> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CustomerEntity> findByUuid(@PathVariable UUID uuid) {
        CustomerEntity customer = customerService.findByUuid(uuid);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody NewCustomerDTO newCustomerDTO) {
        CustomerEntity createdCustomer = customerService.create(newCustomerDTO);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable UUID uuid,
                                                         @RequestBody CustomerEntity customerEntity) {
        CustomerEntity updatedCustomer = customerService.updateByUuid(uuid, customerEntity);
        if (updatedCustomer != null) {
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable UUID uuid) {
        Boolean isDeleted = customerService.deleteByUuid(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
