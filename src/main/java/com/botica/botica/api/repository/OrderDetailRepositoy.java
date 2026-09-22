package com.botica.botica.api.repository;

import com.botica.botica.api.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepositoy extends JpaRepository<OrderDetail, Long> {
}
