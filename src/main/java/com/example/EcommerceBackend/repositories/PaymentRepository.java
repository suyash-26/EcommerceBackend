package com.example.EcommerceBackend.repositories;

import com.example.EcommerceBackend.entities.Order;
import com.example.EcommerceBackend.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByOrder(Order order);
}
