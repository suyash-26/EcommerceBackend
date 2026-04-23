package com.example.EcommerceBackend.dto.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdeerItemDTO {
    private Long product_id;
    private String product_name;
    private Integer quantity;
    private Double price;
}
