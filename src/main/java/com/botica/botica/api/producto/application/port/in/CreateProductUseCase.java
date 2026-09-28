package com.botica.botica.api.producto.application.port.in;

import com.botica.botica.api.producto.domain.model.Product;

public interface CreateProductUseCase {
    Product create(CreateProductCommand productCmd);
}
