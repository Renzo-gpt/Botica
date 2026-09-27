package com.botica.botica.api.controller;

import com.botica.botica.api.entity.Order;
import com.botica.botica.api.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @GetMapping
    public List<Order> findAll(){
        return this.orderService.findAll();
    }

    @PostMapping

    @GetMapping("/{id}")

    @DeleteMapping("/{id}")

}
