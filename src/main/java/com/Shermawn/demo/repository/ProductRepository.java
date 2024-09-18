package com.Shermawn.demo.repository;

import com.Shermawn.demo.models.OrderModel;
import com.Shermawn.demo.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}