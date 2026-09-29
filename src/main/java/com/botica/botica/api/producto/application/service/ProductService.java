package com.botica.botica.api.producto.application.service;

import com.botica.botica.api.producto.application.port.in.*;
import com.botica.botica.api.producto.application.port.out.ProductRepositoryPort;
import com.botica.botica.api.producto.domain.model.Product;
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
        return this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

    }

    @Override
    public Product update(UpdateProductCommand updateProductCmd) {
        Product existingProduct = this.repository.findById(updateProductCmd.getId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + updateProductCmd.getId()));

        Product p = new Product();
        p.setId(updateProductCmd.getId());
        p.setName(updateProductCmd.getName());
        p.setStock(updateProductCmd.getStock());
        p.setPrice(updateProductCmd.getPrice());
        p.setStatus(updateProductCmd.getStatus());
        p.setExpirationDate(updateProductCmd.getExpirationDate());

        return this.repository.save(p);
    }
}
