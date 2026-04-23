package com.example.EcommerceBackend.dto.cart;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.id.IntegralDataTypeHolder;

@Getter
@Setter
public class CartItemDTO {
    private Long productId;
    private String productName;
    private IntegralDataTypeHolder quantity;
    private Double price;
}
