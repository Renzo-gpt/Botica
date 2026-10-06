package com.botica.botica.api.botica.infrastructure.adapter.out;

import com.botica.botica.api.botica.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
