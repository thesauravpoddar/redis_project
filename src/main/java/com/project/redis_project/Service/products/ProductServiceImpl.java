package com.project.redis_project.Service.products;

import com.project.redis_project.Dto.ProductDto.ProductDto;
import com.project.redis_project.Repositries.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        if(productRepo.existsProductByProductName(productDto.productName())) {
            log.error("product with this name already exists");
            throw new IllegalArgumentException("product with this name already exists");
        }

        return null;
    }
}
