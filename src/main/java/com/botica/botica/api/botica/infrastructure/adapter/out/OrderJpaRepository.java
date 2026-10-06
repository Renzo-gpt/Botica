package com.botica.botica.api.botica.infrastructure.adapter.out;

import com.botica.botica.api.botica.infrastructure.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity,Long> {
}
