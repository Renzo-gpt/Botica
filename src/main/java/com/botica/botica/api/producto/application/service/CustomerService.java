package com.botica.botica.api.producto.application.service;

import com.botica.botica.api.producto.application.port.in.CreateCustomerCommand;
import com.botica.botica.api.producto.application.port.in.CreateCustomerUseCase;
import com.botica.botica.api.producto.application.port.in.GetCustomerUseCase;
import com.botica.botica.api.producto.application.port.out.CustomerRepositoryPort;
import com.botica.botica.api.producto.domain.exception.CustomerAlreadyExistsException;
import com.botica.botica.api.producto.domain.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CreateCustomerUseCase, GetCustomerUseCase {

    CustomerRepositoryPort repository;

    public CustomerService (CustomerRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(CreateCustomerCommand customerCmd) {

        if (repository.existsByDni(customerCmd.getDni())) {
            throw new CustomerAlreadyExistsException("The customer with DNI " + customerCmd.getDni() + " already exists.");
        }

        if (repository.existsByEmail(customerCmd.getEmail())) {
            throw new CustomerAlreadyExistsException("The customer with email " + customerCmd.getEmail() + " already existis.");
        }

        Customer c = new Customer();
        c.setDni(customerCmd.getDni());
        c.setFirstName(customerCmd.getFirstName());
        c.setLastName(customerCmd.getLastName());
        c.setPhone(customerCmd.getPhone());
        c.setEmail(customerCmd.getEmail());

        return this.repository.save(c);
    }

    @Override
    public List<Customer> findAll() {
        return this.repository.findAll();
    }
}
