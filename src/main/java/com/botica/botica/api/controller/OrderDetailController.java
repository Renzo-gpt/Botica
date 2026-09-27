package com.botica.botica.api.controller;

import com.botica.botica.api.entity.OrderDetail;
import com.botica.botica.api.service.OrderDetailService;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService){
        this.orderDetailService = orderDetailService;
    }

    @GetMapping
    public List<OrderDetail> findAll(){
        return this.orderDetailService.findAll();
    }

    @PostMapping
    public OrderDetail create(@RequestBody OrderDetail orderDetail){
        return this.orderDetailService.create(orderDetail);
    }

    @GetMapping("/{id}")
    public OrderDetail findById(@PathVariable Long id){
        return this.orderDetailService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.orderDetailService.delete(id);
    }

}
