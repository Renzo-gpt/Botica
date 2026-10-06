package com.botica.botica.api.botica.application.port.out;

import com.botica.botica.api.botica.domain.model.Customer;

import java.util.List;

public interface CustomerRepositoryPort {
    Customer save(Customer customer);
    List<Customer> findAll();
    boolean existsByDni(String dni);
    boolean existsByEmail(String email);
}
