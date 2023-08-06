package com.yamacbayin.erp.service;

import com.yamacbayin.erp.database.entity.InvoiceEntity;
import com.yamacbayin.erp.database.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceService implements IService<InvoiceEntity, InvoiceEntity> {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public InvoiceEntity create(InvoiceEntity invoiceEntity) {
        return invoiceRepository.save(invoiceEntity);
    }

    @Override
    public List<InvoiceEntity> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public InvoiceEntity findByUuid(UUID uuid) {
        Optional<InvoiceEntity> invoiceEntityOptional = invoiceRepository.findByUuid(uuid);
        return invoiceEntityOptional.orElse(null);
    }

    @Override
    public InvoiceEntity updateByUuid(UUID uuid, InvoiceEntity invoiceEntity) {
        InvoiceEntity dbInvoice = findByUuid(uuid);

        if (dbInvoice != null) {
            dbInvoice.setTotalAmount(invoiceEntity.getTotalAmount());
            dbInvoice.setTotalAmountWithoutTax(invoiceEntity.getTotalAmountWithoutTax());
            dbInvoice.setTotalAmountWithoutTax(invoiceEntity.getTotalAmountWithoutTax());
            dbInvoice.setOrder(invoiceEntity.getOrder());
            return invoiceRepository.save(dbInvoice);
        }

        return null;
    }

    @Override
    public Boolean deleteByUuid(UUID uuid) {
        InvoiceEntity invoice = findByUuid(uuid);

        if (invoice != null) {
            invoiceRepository.deleteByUuid(uuid);
            return true;
        }
        return false;
    }
}
