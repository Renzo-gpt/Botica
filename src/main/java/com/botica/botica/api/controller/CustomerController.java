package com.botica.botica.api.controller;

import com.botica.botica.api.entity.Customer;
import com.botica.botica.api.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> findAll(){
        return this.customerService.findAll();
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return this.customerService.create(customer);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id){
        return this.customerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.customerService.delete(id);
    }


}
