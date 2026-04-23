package com.example.EcommerceBackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
//@Getter
//@Setter
//@Table(name = "cart_items")
//public class CartItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private int quantity;
//
//
//    @OneToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
//    @ManyToOne
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
//}

@Entity
@Getter @Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Cart cart;
}
