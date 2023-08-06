package com.yamacbayin.erp.controller;

import com.yamacbayin.erp.database.entity.InvoiceEntity;
import com.yamacbayin.erp.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<InvoiceEntity> findAll() {
        return invoiceService.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<InvoiceEntity> findByUuid(@PathVariable UUID uuid) {
        InvoiceEntity invoice = invoiceService.findByUuid(uuid);
        if (invoice != null) {
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<InvoiceEntity> createInvoice(@RequestBody InvoiceEntity invoiceEntity) {
        InvoiceEntity invoice = invoiceService.create(invoiceEntity);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<InvoiceEntity> updateInvoice(@PathVariable UUID uuid,
                                                       @RequestBody InvoiceEntity invoiceEntity) {
        InvoiceEntity invoice = invoiceService.updateByUuid(uuid, invoiceEntity);
        if (invoice != null) {
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Boolean> deleteInvoice(@PathVariable UUID uuid) {
        Boolean isDeleted = invoiceService.deleteByUuid(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }


}
