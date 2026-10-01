package com.botica.botica.api.producto.application.service;

import com.botica.botica.api.producto.application.port.in.CreateOrderCommand;
import com.botica.botica.api.producto.application.port.in.CreateOrderUseCase;
import com.botica.botica.api.producto.application.port.in.GetOrderUseCase;
import com.botica.botica.api.producto.application.port.out.OrderRepositoryPort;
import com.botica.botica.api.producto.domain.exception.OrderNotFoundException;
import com.botica.botica.api.producto.domain.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService implements CreateOrderUseCase, GetOrderUseCase {
    OrderRepositoryPort orderRepositoryPort;

    public OrderService(OrderRepositoryPort orderRepositoryPort){
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public Order create(CreateOrderCommand orderCmd) {
        Order order = new Order();
                order.setTotal(orderCmd.getTotal());
                order.setPaymentType(orderCmd.getPaymentType());
                order.setDate(LocalDateTime.now());
        return this.orderRepositoryPort.save(order);
    }

    @Override
    public List<Order> findAll() {
        return this.orderRepositoryPort.findAll();
    }

    @Override
    public Order findById(Long id) {
        return this.orderRepositoryPort.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Product not found with id: " + id));
    }
}
