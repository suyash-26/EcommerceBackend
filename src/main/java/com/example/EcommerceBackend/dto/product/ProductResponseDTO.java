package com.example.EcommerceBackend.dto.product;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private String brand;
}
