package com.botica.botica.api.botica.application.port.in;

import com.botica.botica.api.botica.domain.model.Product;

public interface CreateProductUseCase {
    Product create(CreateProductCommand productCmd);
}
