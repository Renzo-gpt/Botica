package com.botica.botica.api.botica.application.port.out;

import com.botica.botica.api.botica.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
