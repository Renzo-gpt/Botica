package com.botica.botica.api.producto.application.port.in;

import com.botica.botica.api.producto.domain.model.Customer;
import java.util.List;

public interface GetCustomerUseCase {
    List<Customer> findAll();
}
