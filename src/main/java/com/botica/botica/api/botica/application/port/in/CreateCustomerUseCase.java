package com.botica.botica.api.botica.application.port.in;

import com.botica.botica.api.botica.domain.model.Customer;

public interface CreateCustomerUseCase{
    Customer create (CreateCustomerCommand customerCmd);


}
