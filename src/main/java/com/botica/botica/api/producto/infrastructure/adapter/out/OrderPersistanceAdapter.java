package com.botica.botica.api.producto.infrastructure.adapter.out;

import com.botica.botica.api.producto.application.port.out.OrderRepositoryPort;
import com.botica.botica.api.producto.domain.model.Order;
import com.botica.botica.api.producto.infrastructure.entities.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderPersistanceAdapter implements OrderRepositoryPort {

    private final OrderJpaRepository orderJpaRepository;

    public OrderPersistanceAdapter(OrderJpaRepository orderJpaRepository){
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderSaved = this.orderJpaRepository.save(OrderPersistanceMapper.toOrderEntity(order));
        return OrderPersistanceMapper.toOrder(orderSaved);
    }

    @Override
    public List<Order> findAll() {
        return orderJpaRepository.findAll().stream()
                .map(OrderPersistanceMapper::toOrder)
                .toList();
    }

    @Override
    public Optional<Order> findById(Long id) {
       Optional<OrderEntity> orderEntity = orderJpaRepository.findById(id);
        return orderEntity.map(OrderPersistanceMapper::toOrder);
    }
}
