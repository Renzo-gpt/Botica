package com.botica.botica.api.producto.application.service;

import com.botica.botica.api.producto.application.port.in.CreateCustomerCommand;
import com.botica.botica.api.producto.application.port.in.CreateCustomerUseCase;
import com.botica.botica.api.producto.application.port.out.CustomerRepositoryPort;
import com.botica.botica.api.producto.domain.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CreateCustomerUseCase {

    CustomerRepositoryPort repository;

    public CustomerService (CustomerRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(CreateCustomerCommand customerCmd) {
        Customer c = new Customer();
            c.setDni(customerCmd.getDni());
            c.setFirstName(customerCmd.getFirstName());
            c.setLastName(customerCmd.getLastName());
            c.setPhone(customerCmd.getPhone());
            c.setEmail(customerCmd.getEmail());

        return this.repository.save(c);
    }
}
