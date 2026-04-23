package com.example.EcommerceBackend.dto.cart;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartResponseDTO {
    private List<CartItemDTO> items;
    private Double totalAmount;
}
