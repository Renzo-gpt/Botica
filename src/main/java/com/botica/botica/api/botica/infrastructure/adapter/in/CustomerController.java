package com.botica.botica.api.botica.infrastructure.adapter.in;

import com.botica.botica.api.botica.application.port.in.CreateCustomerCommand;
import com.botica.botica.api.botica.application.port.in.CreateCustomerUseCase;
import com.botica.botica.api.botica.application.port.in.GetCustomerUseCase;
import com.botica.botica.api.botica.domain.model.Customer;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CreateCustomerUseCase createCustomerUseCase;
    private final GetCustomerUseCase getCustomerUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase, GetCustomerUseCase getCustomerUseCase){
        this.createCustomerUseCase = createCustomerUseCase;
        this.getCustomerUseCase = getCustomerUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDto create (@Valid @RequestBody CustomerRequestDto request){
        CreateCustomerCommand command = CustomerWebMapper.toCommand(request);
        Customer customer = createCustomerUseCase.create(command);
        return CustomerWebMapper.toCustomerResponseDto(customer);
    }

    @RequestMapping
    public List<CustomerResponseDto> findAll(){
        return CustomerWebMapper.toListOfCustomerResponseDto(getCustomerUseCase.findAll());
    }


}
