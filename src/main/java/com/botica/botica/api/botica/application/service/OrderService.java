package com.botica.botica.api.botica.application.service;

import com.botica.botica.api.botica.application.port.in.CreateOrderCommand;
import com.botica.botica.api.botica.application.port.in.CreateOrderUseCase;
import com.botica.botica.api.botica.application.port.in.GetOrderUseCase;
import com.botica.botica.api.botica.application.port.out.OrderRepositoryPort;
import com.botica.botica.api.botica.domain.exception.OrderNotFoundException;
import com.botica.botica.api.botica.domain.model.Order;
import com.botica.botica.api.botica.domain.payment.PaymentStrategy;
import com.botica.botica.api.botica.domain.payment.PaymentStrategyFactory;
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

        PaymentStrategy strategy = PaymentStrategyFactory.getStrategy(orderCmd.getPaymentType());

        order.setTotal(strategy.calculateTotal(orderCmd.getTotal()));
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
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
    }
}
