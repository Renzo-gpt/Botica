package com.botica.botica.api.producto.infrastructure.adapter.out;

import com.botica.botica.api.producto.domain.model.Order;
import com.botica.botica.api.producto.infrastructure.entities.CustomerEntity;
import com.botica.botica.api.producto.infrastructure.entities.OrderEntity;

public class OrderPersistanceMapper {

    public static OrderEntity toOrderEntity(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setDate(order.getDate());
        entity.setTotal(order.getTotal());
        entity.setPaymentType(order.getPaymentType());

        if (order.getCustomerId() != null) {
            CustomerEntity customer = new CustomerEntity();
            customer.setId(order.getCustomerId());
            entity.setCustomer(customer);
        }

        return entity;
    }

    public static Order toOrder(OrderEntity orderEntity) {
        Long customerId = null;
        if(orderEntity.getCustomer() != null){
            customerId = orderEntity.getCustomer().getId();
        }

        return new Order(
                orderEntity.getId(),
                customerId,
                orderEntity.getDate(),
                orderEntity.getTotal(),
                orderEntity.getPaymentType()
        );


    }
}