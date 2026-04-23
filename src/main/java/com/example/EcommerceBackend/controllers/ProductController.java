package com.example.EcommerceBackend.controllers;

import com.example.EcommerceBackend.dto.product.ProductRequestDTO;
import com.example.EcommerceBackend.dto.product.ProductResponseDTO;
import com.example.EcommerceBackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO product){
        return ResponseEntity.ok(productService.addProduct(product));
    }
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
