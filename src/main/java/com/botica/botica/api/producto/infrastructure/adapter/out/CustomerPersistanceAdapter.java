package com.botica.botica.api.producto.infrastructure.adapter.out;

import com.botica.botica.api.producto.application.port.out.CustomerRepositoryPort;
import com.botica.botica.api.producto.domain.model.Customer;
import com.botica.botica.api.producto.infrastructure.adapter.in.CustomerWebMapper;
import com.botica.botica.api.producto.infrastructure.entities.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerPersistanceAdapter
        implements CustomerRepositoryPort {

    private final CustomerJpaRepository customerJpaRepository;

    public CustomerPersistanceAdapter(CustomerJpaRepository customerJpaRepository){
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entitySaved = customerJpaRepository.save(
                CustomerPersistanceMapper
                        .toCustomerEntity(customer));
        return CustomerPersistanceMapper.toCustomer(entitySaved);

    }

    @Override
    public List<Customer> findAll() {
        return customerJpaRepository.findAll().stream()
                .map(CustomerPersistanceMapper::toCustomer)
                .toList();
    }

    @Override
    public boolean existsByDni(String dni) {
        return customerJpaRepository.existsByDni(dni);
    }

    @Override
    public boolean existsByEmail(String email) {
        return customerJpaRepository.existsByEmail(email);
    }
}
