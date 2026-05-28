package com.project.redis_project.Controller;

import com.project.redis_project.Dto.ProductDto.ProductDto;
import com.project.redis_project.Service.products.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ResponseEntity<ProductDto> CreateProduct(
            @Valid @RequestBody ProductDto productDto
    ) {
        ProductDto product = productService.createProduct(productDto);
    }

}
