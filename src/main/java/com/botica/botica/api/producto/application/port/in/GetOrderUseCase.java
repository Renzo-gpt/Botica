package com.botica.botica.api.producto.application.port.in;

import com.botica.botica.api.producto.domain.model.Order;

import java.util.List;


public interface GetOrderUseCase {
    List<Order> findAll();
    Order findById(Long id);
}
