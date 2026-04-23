package com.example.EcommerceBackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//enum Category{
//    ELECTRONICS,
//    DECOR
//}

//@Entity
//@Getter
//@Setter
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String name;
//    private Category category;
//    private int stock;
//}

@Entity
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 2000)
    private String description;

    private Double price;

    private Integer stock;

    private String category;

    private String brand;

    private boolean isActive = true;
}
