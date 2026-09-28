package com.botica.botica.api.producto.infrastructure.adapter.in;

import com.botica.botica.api.producto.application.port.in.CreateCustomerCommand;
import com.botica.botica.api.producto.application.port.in.CreateCustomerUseCase;
import com.botica.botica.api.producto.domain.model.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CreateCustomerUseCase createCustomerUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase){
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @PostMapping
    public CustomerResponseDto create (@RequestBody CustomerRequestDto request){
            CreateCustomerCommand cmd = new CreateCustomerCommand();
            cmd.setDni(request.getDni());
            cmd.setFirstName(request.getFirstName());
            cmd.setLastName(request.getLastName());
            cmd.setPhone(request.getPhone());
            cmd.setEmail(request.getEmail());

            Customer customerCreado = CreateCustomerCommand.create(cmd);


            return this.createCustomerUseCase.create(r);
    }


}
