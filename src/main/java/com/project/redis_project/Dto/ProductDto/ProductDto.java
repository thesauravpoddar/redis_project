package com.project.redis_project.Dto.ProductDto;

import com.project.redis_project.Entities.Enums.Category;
import com.project.redis_project.Entities.Enums.Stock;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.UUID;
public record ProductDto(
        UUID productId,
        @NotBlank(message = "product name cannot be blank")
         String productName,
        @NotBlank(message = "description cannot be blank")
         String description,
        BigDecimal price,
        Stock stock,
        Category category
) {}

