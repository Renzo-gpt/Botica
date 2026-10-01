package com.botica.botica.api.producto.application.port.out;

import com.botica.botica.api.producto.domain.model.Customer;

import java.util.List;

public interface CustomerRepositoryPort {
    Customer save(Customer customer);
    List<Customer> findAll();
    boolean existsByDni(String dni);
    boolean existsByEmail(String email);
}
