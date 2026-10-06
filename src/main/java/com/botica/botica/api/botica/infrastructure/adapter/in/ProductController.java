package com.botica.botica.api.botica.infrastructure.adapter.in;

import com.botica.botica.api.botica.application.port.in.*;
import com.botica.botica.api.botica.domain.model.Product;
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
        CreateProductCommand createProductCommand = ProductWebMapper.toCommand(productRequest);
        Product product = createProductUseCase.create(createProductCommand);
        return ProductWebMapper.toProductResponseDto(product);
    }

    @GetMapping
    public List<ProductResponseDto> findAll(){
        return ProductWebMapper.toListProductResponseDto(getProductUseCase.findAll());
    }

    @GetMapping("/{id}")
    public ProductResponseDto findById(@PathVariable Long id){
        return ProductWebMapper.toProductResponseDto(getProductUseCase.findById(id));

    }

    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable Long id,@Valid @RequestBody ProductRequestDto productRequest){
        UpdateProductCommand updateCommand = ProductWebMapper.toUpdateCommand(id, productRequest);
        Product updateProduct = updateProductUseCase.update(updateCommand);
        return ProductWebMapper.toProductResponseDto(updateProduct);
    }
}
