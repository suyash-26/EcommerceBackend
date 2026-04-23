package com.example.EcommerceBackend.repositories;

import com.example.EcommerceBackend.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
