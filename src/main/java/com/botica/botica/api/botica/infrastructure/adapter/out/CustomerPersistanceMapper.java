package com.botica.botica.api.botica.infrastructure.adapter.out;

import com.botica.botica.api.botica.domain.model.Customer;
import com.botica.botica.api.botica.infrastructure.entities.CustomerEntity;

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
