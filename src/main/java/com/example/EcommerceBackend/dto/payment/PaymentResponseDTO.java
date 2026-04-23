package com.example.EcommerceBackend.dto.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponseDTO {
    private String status;
    private String transactionId;
}
