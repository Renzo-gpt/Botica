package com.botica.botica.api.producto.application.port.out;

import com.botica.botica.api.producto.domain.model.Customer;

public interface CustomerRepositoryPort {
    Customer save(Customer customer);
}
