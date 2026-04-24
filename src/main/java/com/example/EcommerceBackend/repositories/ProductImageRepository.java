package com.example.EcommerceBackend.repositories;

import com.example.EcommerceBackend.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    // ✅ WHY: Spring derives query automatically → no boilerplate
    List<ProductImage> findByProductId(Long productId);
}