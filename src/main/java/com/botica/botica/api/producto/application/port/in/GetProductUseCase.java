package com.botica.botica.api.producto.application.port.in;

import com.botica.botica.api.producto.domain.model.Product;

import java.util.List;

public interface GetProductUseCase {
    List<Product> findAll();
    Product findById(Long id);
}
