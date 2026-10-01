package com.botica.botica.api;

import com.botica.botica.api.producto.application.port.in.CreateOrderCommand;
import com.botica.botica.api.producto.application.port.out.OrderRepositoryPort;
import com.botica.botica.api.producto.application.service.OrderService;
import com.botica.botica.api.producto.domain.exception.OrderNotFoundException;
import com.botica.botica.api.producto.domain.model.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    OrderRepositoryPort orderRepositoryPort;

    @InjectMocks
    OrderService orderService;

    @Test
    void soulSaveOrderOnce() {
        CreateOrderCommand cmd = new CreateOrderCommand();
        cmd.setTotal(new BigDecimal("120.00"));
        cmd.setPaymentType("EFECTIVO");

        Order saveOrder = new Order();
        saveOrder.setTotal(cmd.getTotal());

        when(orderRepositoryPort.save(any(Order.class))).thenReturn(saveOrder);

        Order valueReturned = orderService.create(cmd);

        assertNotNull(valueReturned);
        assertEquals(new BigDecimal("120.00"), valueReturned.getTotal());
        verify(orderRepositoryPort, times(1)).save(any(Order.class));
    }

    @Test
    void shouldThrowWhenOrderNotExists() {
        when(orderRepositoryPort.findById(99L)).thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class,
                () -> orderService.findById(99L));
    }

}
