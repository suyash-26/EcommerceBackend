package com.example.EcommerceBackend.dto.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderResponseDTO {
    private Long orderId;
    private List<OrdeerItemDTO> items;
    private Double totalAmount;
    private String status;
}
