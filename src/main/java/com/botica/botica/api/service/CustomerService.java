package com.botica.botica.api.service;

import com.botica.botica.api.entity.Customer;
import com.botica.botica.api.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
        return this.customerRepository.findAll();
    }

    public Customer findById(Long id){
        return this.customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Orden    con " +id+ " no encontrado!"));
    }

    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }

        /* falta pulir
        public Order update(Long id){
            Order p = this.findById(id);
            return this.create(p);
        }
        */

    public void delete(Long id){
        customerRepository.deleteById(id);
    }

}
