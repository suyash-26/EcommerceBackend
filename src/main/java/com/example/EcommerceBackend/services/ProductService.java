package com.example.EcommerceBackend.services;

import com.example.EcommerceBackend.dto.product.ProductRequestDTO;
import com.example.EcommerceBackend.dto.product.ProductResponseDTO;
import com.example.EcommerceBackend.entities.Product;
import com.example.EcommerceBackend.mapStruct.ProductRequestMapper;
import com.example.EcommerceBackend.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductRequestMapper productRequestMapper;
    ProductService(ProductRepository productRepository,ProductRequestMapper productRequestMapper){
        this.productRepository = productRepository;
        this.productRequestMapper = productRequestMapper;
    }
    public ProductResponseDTO addProduct(ProductRequestDTO product){
        Product p = productRequestMapper.toEntity(product);
//        Product p = new Product();
//        p.setName(product.getName());
        Product savedProduct = productRepository.save(p);
//        ProductResponseDTO res = new ProductResponseDTO();
//        res.setName(savedProduct.getName());
//        return res;
        return productRequestMapper.toResponse(savedProduct);
    }
    public List<ProductResponseDTO> getAllProducts(){
        List<Product> products =  productRepository.findAll();
        List<ProductResponseDTO> res = products.stream().map(product -> {
            ProductResponseDTO p = productRequestMapper.toResponse(product);
            return p;
        }).toList();
        return res;
    }
}
