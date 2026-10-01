package com.botica.botica.api;

import com.botica.botica.api.producto.domain.model.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    void shouldCreateOrderWithCorrectAttributes() {
        LocalDateTime now = LocalDateTime.now();
        BigDecimal total = new BigDecimal("150.00");
        String paymentType = "EFECTIVO";

        Order order = new Order();
        order.setId(1L);
        order.setTotal(total);
        order.setPaymentType(paymentType);
        order.setDate(now);

        assertNotNull(order);
        assertEquals(1L, order.getId());
        assertEquals(new BigDecimal("150.00"), order.getTotal());
        assertEquals("EFECTIVO", order.getPaymentType());
        assertEquals(now, order.getDate());
    }
}
