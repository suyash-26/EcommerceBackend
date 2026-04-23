package com.example.EcommerceBackend.services;

import com.example.EcommerceBackend.repositories.CartItemRepository;
import com.example.EcommerceBackend.repositories.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    CartService(CartRepository cartRepository){

    }

}
