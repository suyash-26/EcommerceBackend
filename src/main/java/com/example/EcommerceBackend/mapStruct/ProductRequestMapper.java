package com.example.EcommerceBackend.mapStruct;

import com.example.EcommerceBackend.dto.product.ProductRequestDTO;
import com.example.EcommerceBackend.dto.product.ProductResponseDTO;
import com.example.EcommerceBackend.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {
    Product toEntity(ProductRequestDTO productRequestDTO);
    ProductResponseDTO toResponse(Product product);
}
