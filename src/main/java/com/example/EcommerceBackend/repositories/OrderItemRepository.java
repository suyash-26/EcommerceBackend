package com.example.EcommerceBackend.repositories;

import com.example.EcommerceBackend.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
