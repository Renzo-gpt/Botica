package com.botica.botica.api.botica.infrastructure.adapter.out;

import com.botica.botica.api.botica.domain.model.Product;
import com.botica.botica.api.botica.infrastructure.entities.ProductEntity;

public class ProductPersistanceMapper {

    public static ProductEntity toProductEntity (Product product){
        ProductEntity productEntity = new ProductEntity(
                product.getName(),
                product.getStock(),
                product.getPrice(),
                product.getStatus(),
                product.getExpirationDate());
        productEntity.setId(product.getId());
        return productEntity;
    }

    public static Product toProduct (ProductEntity productEntity){
        return new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getStock(),
                productEntity.getPrice(),
                productEntity.getStatus(),
                productEntity.getExpirationDate());
    }
}
