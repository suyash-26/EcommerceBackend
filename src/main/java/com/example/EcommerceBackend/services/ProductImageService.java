package com.example.EcommerceBackend.services;

import com.example.EcommerceBackend.dto.productImages.ProductImageRequestDTO;
import com.example.EcommerceBackend.entities.Product;
import com.example.EcommerceBackend.entities.ProductImage;
import com.example.EcommerceBackend.repositories.ProductImageRepository;
import com.example.EcommerceBackend.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductImageService {

    private final ProductImageRepository productImageRepository;
    private final ProductRepository productRepository;

    public ProductImageService(ProductImageRepository productImageRepository,
                               ProductRepository productRepository) {
        this.productImageRepository = productImageRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public List<ProductImage> addProductImage(ProductImageRequestDTO images) {

        // ✅ WHY: Ensure parent exists → avoid FK constraint failure
        Product product = productRepository.findById(images.getProductId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Product not found"));

        // ✅ WHY: Avoid duplicate inserts (common real-world issue)
        List<ProductImage> imageList = images.getUrls().stream()
                .distinct()
                .map(url -> {
                    ProductImage img = new ProductImage();
                    img.setImageUrl(url);
                    img.setProduct(product); // attach managed entity
                    return img;
                })
                .toList();

        // ✅ WHY: saveAll → single batch instead of multiple DB calls
        return productImageRepository.saveAll(imageList);
    }

    public List<ProductImage> getImagesByProductId(Long productId) {

        // ✅ WHY: Optional validation (depends on business)
        if (!productRepository.existsById(productId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product not found");
        }

        return productImageRepository.findByProductId(productId);
    }
}