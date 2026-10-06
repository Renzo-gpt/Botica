package com.botica.botica.api.botica.application.port.out;

import com.botica.botica.api.botica.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepositoryPort {
    Order save(Order order);
    List<Order> findAll();
    Optional<Order> findById(Long id);
}
