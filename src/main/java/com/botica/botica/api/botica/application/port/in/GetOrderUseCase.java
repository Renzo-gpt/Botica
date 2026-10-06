package com.botica.botica.api.botica.application.port.in;

import com.botica.botica.api.botica.domain.model.Order;

import java.util.List;


public interface GetOrderUseCase {
    List<Order> findAll();
    Order findById(Long id);
}
