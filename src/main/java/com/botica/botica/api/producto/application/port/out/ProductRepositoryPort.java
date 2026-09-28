package com.botica.botica.api.producto.application.port.out;

import com.botica.botica.api.producto.domain.model.Product;

import java.util.List;

public interface ProductRepositoryPort {
    Product save(Product product);
    List<Product> findAll();
    Product findById(Long id);
    Product update(Product product);
}
