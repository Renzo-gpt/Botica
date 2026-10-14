package com.botica.botica.api.botica.infrastructure.adapter.in;

import com.botica.botica.api.botica.application.port.in.*;
import com.botica.botica.api.botica.domain.model.Product;
import com.botica.botica.api.botica.infrastructure.adapter.in.Dto.ProductRequestDto;
import com.botica.botica.api.botica.infrastructure.adapter.in.Dto.ProductResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, GetProductUseCase getProductUseCase, UpdateProductUseCase updateProductUseCase){
        this.createProductUseCase = createProductUseCase;
        this.getProductUseCase = getProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto create (@Valid @RequestBody ProductRequestDto productRequest){
        CreateProductCommand createProductCommand = CustomerController.ProductWebMapper.toCommand(productRequest);
        Product product = createProductUseCase.create(createProductCommand);
        return CustomerController.ProductWebMapper.toProductResponseDto(product);
    }

    @GetMapping
    public List<ProductResponseDto> findAll(){
        return CustomerController.ProductWebMapper.toListProductResponseDto(getProductUseCase.findAll());
    }

    @GetMapping("/{id}")
    public ProductResponseDto findById(@PathVariable Long id){
        return CustomerController.ProductWebMapper.toProductResponseDto(getProductUseCase.findById(id));

    }

    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable Long id,@Valid @RequestBody ProductRequestDto productRequest){
        UpdateProductCommand updateCommand = CustomerController.ProductWebMapper.toUpdateCommand(id, productRequest);
        Product updateProduct = updateProductUseCase.update(updateCommand);
        return CustomerController.ProductWebMapper.toProductResponseDto(updateProduct);
    }
}
