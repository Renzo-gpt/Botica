package com.botica.botica.api.repository;

import com.botica.botica.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
        }


