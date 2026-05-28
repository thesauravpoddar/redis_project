package com.project.redis_project.Service.products;

import com.project.redis_project.Dto.ProductDto.ProductDto;
import jakarta.validation.Valid;

import java.util.UUID;

public interface ProductService {
    ProductDto createProduct(@Valid ProductDto productDto);


    ProductDto getProduct(UUID id);
}
