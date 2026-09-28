package com.botica.botica.api.producto.application.port.in;

import com.botica.botica.api.producto.domain.model.Order;

public interface CreateOrderUseCase {
    Order create(CreateOrderCommand orderCmd);
}
