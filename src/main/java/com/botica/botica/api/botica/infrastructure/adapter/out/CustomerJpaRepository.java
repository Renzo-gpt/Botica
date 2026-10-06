package com.botica.botica.api.botica.infrastructure.adapter.out;

import com.botica.botica.api.botica.infrastructure.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
    boolean existsByDni(String dni);
    boolean existsByEmail(String email);
}
