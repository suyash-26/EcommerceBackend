package com.example.EcommerceBackend.repositories;

import com.example.EcommerceBackend.entities.Cart;
import com.example.EcommerceBackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart> findByUser(User user);
}
