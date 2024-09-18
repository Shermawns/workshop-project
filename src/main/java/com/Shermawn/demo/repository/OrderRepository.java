package com.Shermawn.demo.repository;

import com.Shermawn.demo.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
