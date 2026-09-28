package com.botica.botica.api.producto.application.port.in;

import com.botica.botica.api.producto.domain.model.Customer;

public interface CreateCustomerUseCase{
    Customer create (CreateCustomerCommand customerCmd);


}
