package com.yamacbayin.erp.service;

import com.yamacbayin.erp.database.entity.CustomerEntity;
import com.yamacbayin.erp.database.repository.CustomerRepository;
import com.yamacbayin.erp.model.dto.NewCustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService implements IService<CustomerEntity, NewCustomerDTO> {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity create(NewCustomerDTO newCustomerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(newCustomerDTO.getName());
        customerEntity.setSurname(newCustomerDTO.getSurname());
        customerEntity.setEmail(newCustomerDTO.getEmail());
        customerEntity.setAddress(newCustomerDTO.getAddress());
        return customerRepository.save(customerEntity);
    }

    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    public CustomerEntity findByUuid(UUID uuid) {
        Optional<CustomerEntity> optional = customerRepository.findByUuid(uuid);
        return optional.orElse(null);
    }

    @Override
    public CustomerEntity updateByUuid(UUID uuid, CustomerEntity customerEntity) {
        CustomerEntity dbCustomer = findByUuid(uuid);

        if (dbCustomer != null) {
            dbCustomer.setName(customerEntity.getName());
            dbCustomer.setSurname(customerEntity.getSurname());
            dbCustomer.setEmail(customerEntity.getEmail());
            dbCustomer.setAddress(customerEntity.getAddress());

            return customerRepository.save(dbCustomer);
        }

        return null;
    }

    @Override
    public Boolean deleteByUuid(UUID uuid) {
        CustomerEntity customer = findByUuid(uuid);

        if (customer != null) {
            customerRepository.deleteByUuid(uuid);
            return true;
        }
        return false;
    }
}
