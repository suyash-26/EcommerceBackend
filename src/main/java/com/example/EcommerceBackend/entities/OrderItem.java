package com.example.EcommerceBackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
//@Getter
//@Setter
//@Table(name = "order_items")
//public class OrderItem {
//    @Id
//    private long id;
//    private double price;
//    private int quantity;
//
//    @ManyToOne
//    private Product product;
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//}

@Entity
@Getter @Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private Double price; // snapshot price

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;
}
