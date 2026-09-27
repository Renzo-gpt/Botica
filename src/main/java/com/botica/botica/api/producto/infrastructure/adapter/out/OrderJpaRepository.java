package com.botica.botica.api.producto.infrastructure.adapter.out;

import com.botica.botica.api.producto.infrastructure.entities.EntityOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<EntityOrder,Long> {
}
