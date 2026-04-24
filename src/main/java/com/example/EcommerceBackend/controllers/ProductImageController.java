package com.example.EcommerceBackend.controllers;

import com.example.EcommerceBackend.dto.productImages.ProductImageRequestDTO;
import com.example.EcommerceBackend.entities.ProductImage;
import com.example.EcommerceBackend.services.ProductImageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productImages") // (can improve later to RESTful structure)
public class ProductImageController {

    private final ProductImageService productImageService;

    public ProductImageController(ProductImageService productImageService){
        this.productImageService = productImageService;
    }

    @PostMapping("/addImages")
    public ResponseEntity<List<ProductImage>> addProductImages(
            @Valid @RequestBody ProductImageRequestDTO images){

        // ✅ WHY: POST should return 201 CREATED
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productImageService.addProductImage(images));
    }

    @GetMapping("/images/{productId}")
    public ResponseEntity<List<ProductImage>> getImagesByProductId(
            @PathVariable Long productId){

        return ResponseEntity.ok(
                productImageService.getImagesByProductId(productId)
        );
    }
}