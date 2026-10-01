package com.botica.botica.api.producto.infrastructure.adapter.in;

import com.botica.botica.api.producto.application.port.in.CreateOrderCommand;
import com.botica.botica.api.producto.domain.model.Order;

import java.util.List;

public class OrderWebMapper {

    public static CreateOrderCommand toCommand(OrderRequestDto orderRequestDto){
        return new CreateOrderCommand(
                orderRequestDto.getDate(),
                orderRequestDto.getTotal(),
                orderRequestDto.getPaymentType()
        );
    }

    public static OrderResponseDto toResponseDto(Order order){
        return new OrderResponseDto(
                order.getDate(),
                order.getTotal(),
                order.getPaymentType()
        );
    }

    public static List<OrderResponseDto> toListResponse(List<Order> orderList){
        return orderList.stream()
                .map(order -> toResponseDto(order))
                .toList();
    }


}
