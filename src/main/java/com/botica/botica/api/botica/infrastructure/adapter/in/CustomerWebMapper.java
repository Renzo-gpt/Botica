package com.botica.botica.api.botica.infrastructure.adapter.in;

import com.botica.botica.api.botica.application.port.in.CreateCustomerCommand;
import com.botica.botica.api.botica.domain.model.Customer;

import java.util.List;

public class CustomerWebMapper {

    public static CustomerResponseDto toCustomerResponseDto(Customer customer) {
        return new CustomerResponseDto(
                customer.getId(),
                customer.getDni(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhone(),
                customer.getEmail()
        );
    }

    public static List<CustomerResponseDto> toListOfCustomerResponseDto(List<Customer> customerList) {
        return customerList.stream()
                .map(customer -> toCustomerResponseDto(customer))
                .toList();
    }

    public static CreateCustomerCommand toCommand(CustomerRequestDto request) {
        return new CreateCustomerCommand(
                request.getDni(),
                request.getFirstName(),
                request.getLastName(),
                request.getPhone(),
                request.getEmail()
        );
    }
}
