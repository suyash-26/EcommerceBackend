package com.example.EcommerceBackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
//@Getter
//@Setter
//public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String address_line;
//    private String city;
//    private String state;
//    private String country;
//    private int zip_code;
//
//    @ManyToOne
//    private User user;
//}

@Entity
@Getter @Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
