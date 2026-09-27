package com.botica.botica.api.producto.infrastructure.adapter.out;

import com.botica.botica.api.producto.infrastructure.entities.EntityOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailJpaRepository extends JpaRepository<EntityOrderDetail, Long> {
}
