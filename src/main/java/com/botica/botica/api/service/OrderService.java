package com.botica.botica.api.service;

import com.botica.botica.api.entity.Order;
import com.botica.botica.api.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return this.orderRepository.findAll();
    }

    public Order findById(Long id){
        return this.orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Orden    con " +id+ " no encontrado!"));
    }

    public Order create(Order order){
        return orderRepository.save(order);
    }

        /* falta pulir
        public Order update(Long id){
            Order p = this.findById(id);
            return this.create(p);
        }
        */

    public void delete(Long id){
        orderRepository.deleteById(id);
    }

}
