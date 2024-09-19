package com.Shermawn.demo.repository;

import com.Shermawn.demo.models.OrderItemModel;
import com.Shermawn.demo.models.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemModel, OrderItemPK> {
}
