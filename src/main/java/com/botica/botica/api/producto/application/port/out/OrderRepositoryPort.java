package com.botica.botica.api.producto.application.port.out;

import com.botica.botica.api.producto.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepositoryPort {
    Order save(Order order);
    List<Order> findAll();
    Optional<Order> findById(Long id);
}
