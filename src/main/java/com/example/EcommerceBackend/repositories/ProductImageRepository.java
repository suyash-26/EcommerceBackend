package com.example.EcommerceBackend.repositories;

import com.example.EcommerceBackend.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
}
