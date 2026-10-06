package com.botica.botica.api.botica.application.port.in;

import com.botica.botica.api.botica.domain.model.Order;

public interface CreateOrderUseCase {
    Order create(CreateOrderCommand orderCmd);
}
