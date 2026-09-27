package com.botica.botica.api.producto.infrastructure.adapter.out;

import com.botica.botica.api.producto.infrastructure.entities.EntityProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<EntityProduct, Long> {
}
