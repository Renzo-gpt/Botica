package com.botica.botica.api.botica.infrastructure.adapter.in;

import com.botica.botica.api.botica.application.port.in.*;
import com.botica.botica.api.botica.domain.model.Customer;
import com.botica.botica.api.botica.domain.model.Product;
import com.botica.botica.api.botica.infrastructure.adapter.in.Dto.CustomerRequestDto;
import com.botica.botica.api.botica.infrastructure.adapter.in.Dto.CustomerResponseDto;
import com.botica.botica.api.botica.infrastructure.adapter.in.Dto.ProductRequestDto;
import com.botica.botica.api.botica.infrastructure.adapter.in.Dto.ProductResponseDto;
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


    public static class ProductWebMapper {

        public static CreateProductCommand toCommand(ProductRequestDto productRequest){
            return new CreateProductCommand(
                    productRequest.getName(),
                    productRequest.getStock(),
                    productRequest.getPrice(),
                    productRequest.getStatus(),
                    productRequest.getExpirationDate()
            );
        }

        public static UpdateProductCommand toUpdateCommand(Long id, ProductRequestDto productRequest){
            return new UpdateProductCommand(
                    id,
                    productRequest.getName(),
                    productRequest.getStock(),
                    productRequest.getPrice(),
                    productRequest.getStatus(),
                    productRequest.getExpirationDate()
            );


        }

        public static ProductResponseDto toProductResponseDto (Product product){
            return new ProductResponseDto(
                    product.getId(),
                    product.getName(),
                    product.getStock(),
                    product.getPrice(),
                    product.getStatus(),
                    product.getExpirationDate()
            );
        }

        public static List<ProductResponseDto> toListProductResponseDto (List<Product> productList){
            return productList.stream()
                    .map(product -> toProductResponseDto(product))
                    .toList();
        }

    }
}
