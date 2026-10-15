package com.botica.botica.api.botica.infrastructure.adapter.in;

import com.botica.botica.api.botica.application.port.in.CreateOrderCommand;
import com.botica.botica.api.botica.domain.model.Order;
import com.botica.botica.api.botica.domain.model.PaymentType;
import com.botica.botica.api.botica.infrastructure.adapter.in.Dto.OrderRequestDto;
import com.botica.botica.api.botica.infrastructure.adapter.in.Dto.OrderResponseDto;

import java.util.List;

public class OrderWebMapper {

    public static CreateOrderCommand toCommand(OrderRequestDto orderRequestDto){
        PaymentType type = PaymentType.valueOf(orderRequestDto.getPaymentType().toUpperCase());
        return new CreateOrderCommand(
                orderRequestDto.getDate(),
                orderRequestDto.getTotal(),
                type
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
