package com.example.EcommerceBackend.dto.productImages;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductImageRequestDTO {

    // ✅ WHY: Validate early → fail fast before hitting DB
    @NotNull(message = "ProductId is required")
    private Long productId;

    // ✅ WHY: Prevent empty requests (useless DB calls)
    @NotEmpty(message = "Image URLs cannot be empty")
    private List<
            @NotBlank(message = "URL cannot be blank") // each element validated
                    String> urls;
}