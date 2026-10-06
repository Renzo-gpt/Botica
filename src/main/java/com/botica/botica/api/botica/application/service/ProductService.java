package com.botica.botica.api.botica.application.service;

import com.botica.botica.api.botica.application.port.in.*;
import com.botica.botica.api.botica.application.port.out.ProductRepositoryPort;
import com.botica.botica.api.botica.domain.exception.ProductInactiveException;
import com.botica.botica.api.botica.domain.exception.ProductNotFoundException;
import com.botica.botica.api.botica.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements CreateProductUseCase, GetProductUseCase, UpdateProductUseCase {

    ProductRepositoryPort repository;

    public ProductService(ProductRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    public Product create(CreateProductCommand productCmd) {
        Product p = new Product();
                p.setName(productCmd.getName());
                p.setStock(productCmd.getStock());
                p.setPrice(productCmd.getPrice());
                p.setStatus(productCmd.getStatus());
                p.setExpirationDate(productCmd.getExpirationDate());
        return repository.save(p);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Product product = this.repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

        if (Boolean.FALSE.equals(product.getStatus())){
            throw new ProductInactiveException("The product with id " + id + " is inactive.");
        }

        return product;
    }

    @Override
    public Product update(UpdateProductCommand updateProductCmd) {
        Product product = this.repository.findById(updateProductCmd.getId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + updateProductCmd.getId()));

        product.setName(updateProductCmd.getName());
        product.setStock(updateProductCmd.getStock());
        product.setPrice(updateProductCmd.getPrice());
        product.setStatus(updateProductCmd.getStatus());
        product.setExpirationDate(updateProductCmd.getExpirationDate());

        return this.repository.save(product);
    }
}
