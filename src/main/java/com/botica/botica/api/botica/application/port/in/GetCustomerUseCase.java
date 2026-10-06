package com.botica.botica.api.botica.application.port.in;

import com.botica.botica.api.botica.domain.model.Customer;
import java.util.List;

public interface GetCustomerUseCase {
    List<Customer> findAll();
}
