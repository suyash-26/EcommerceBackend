package com.example.EcommerceBackend.dto.order;

import com.example.EcommerceBackend.dto.address.AddressDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    private AddressDTO shippingAddress;
    private AddressDTO billingAddress;
    private String paymentMethod;
}
