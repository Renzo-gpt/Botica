package com.botica.botica.api.producto.infrastructure.adapter.in;

import com.botica.botica.api.producto.application.port.in.CreateProductCommand;
import com.botica.botica.api.producto.application.port.in.UpdateProductCommand;
import com.botica.botica.api.producto.domain.model.Product;

import java.util.List;

public class ProductWebMapper {

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
                product.getName(),
                product.getStock(),
                product.getPrice(),
                product.getExpirationDate()
        );
    }

    public static List<ProductResponseDto> toListProductResponseDto (List<Product> productList){
        return productList.stream()
                .map(product -> toProductResponseDto(product))
                .toList();
    }

}
