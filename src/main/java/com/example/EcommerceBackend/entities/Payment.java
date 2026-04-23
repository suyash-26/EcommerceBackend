package com.example.EcommerceBackend.entities;

import com.example.EcommerceBackend.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
//@Getter
//@Setter
//public class Transaction {
//    @Id
//    private long id;
//    private PaymentMode paymentMode;
//    private double total;
//    private String status;
//    private long create_at;
//
//    @OneToOne
//    private Order order;
//
////    should we store user id here?
//}


@Entity
@Getter @Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentMethod; // CARD, UPI, COD

    @Enumerated(EnumType.STRING)
    private PaymentStatus status; // SUCCESS, FAILED

    private String transactionId;

    @ManyToOne
    private Order order;
}