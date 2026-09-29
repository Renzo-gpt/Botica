package com.botica.botica.api.producto.infrastructure.adapter.out;

import com.botica.botica.api.producto.domain.model.Customer;
import com.botica.botica.api.producto.infrastructure.entities.CustomerEntity;

public class CustomerPersistanceMapper {

    public static CustomerEntity toCustomerEntity (Customer customer){
        CustomerEntity customerEntity = new CustomerEntity(
                customer.getDni(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhone(),
                customer.getEmail()
        );
        customerEntity.setId(customer.getId());

        return customerEntity;
    }

    public static Customer toCustomer (CustomerEntity customerEntity){
        Customer customer = new Customer(
                customerEntity.getId(),
                customerEntity.getDni(),
                customerEntity.getFirstName(),
                customerEntity.getLastName(),
                customerEntity.getPhone(),
                customerEntity.getEmail()
        );
        return customer;
    }

}
