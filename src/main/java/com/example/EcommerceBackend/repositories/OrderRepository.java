package com.example.EcommerceBackend.repositories;

import com.example.EcommerceBackend.entities.Order;
import com.example.EcommerceBackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByUser(User user);
}
