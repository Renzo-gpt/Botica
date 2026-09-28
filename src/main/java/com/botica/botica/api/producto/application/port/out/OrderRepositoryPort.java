package com.botica.botica.api.producto.application.port.out;

import com.botica.botica.api.producto.domain.model.Order;

import java.util.List;

public interface OrderRepositoryPort {
    Order save(Order order);
    List<Order> findAll();
    Order findById(Long id);
}
