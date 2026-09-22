package com.botica.botica.api.service;

import com.botica.botica.api.entity.OrderDetail;
import com.botica.botica.api.repository.OrderDetailRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository){
        this.orderDetailRepository = orderDetailRepository;
    }

    public List<OrderDetail> findAll(){
        return this.orderDetailRepository.findAll();
    }

    public OrderDetail findById(Long id){
        return this.orderDetailRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Orden    con " +id+ " no encontrado!"));
    }

    public OrderDetail create(OrderDetail orderDetail){
        return orderDetailRepository.save(orderDetail);
    }

        /* falta pulir
        public Order update(Long id){
            Order p = this.findById(id);
            return this.create(p);
        }
        */

    public void delete(Long id){
        orderDetailRepository.deleteById(id);
    }

}
