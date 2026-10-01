package com.botica.botica.api.producto.infrastructure.adapter.out;

import com.botica.botica.api.producto.application.port.out.ProductRepositoryPort;
import com.botica.botica.api.producto.domain.model.Product;
import com.botica.botica.api.producto.infrastructure.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductPersistanceAdapter implements ProductRepositoryPort {
    private final ProductJpaRepository productJpaRepository;

    public ProductPersistanceAdapter(ProductJpaRepository productJpaRepository){
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity productSaved = productJpaRepository.save(ProductPersistanceMapper.toProductEntity(product));
        return ProductPersistanceMapper.toProduct(productSaved);
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll().stream()
                .map(ProductPersistanceMapper::toProduct)
                .toList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<ProductEntity> productEntity = productJpaRepository.findById(id);
        return productEntity.map(ProductPersistanceMapper::toProduct);
    }
}
