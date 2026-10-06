package com.botica.botica.api.botica.application.port.in;

import com.botica.botica.api.botica.domain.model.Product;

import java.util.List;

public interface GetProductUseCase {
    List<Product> findAll();
    Product findById(Long id);
}
