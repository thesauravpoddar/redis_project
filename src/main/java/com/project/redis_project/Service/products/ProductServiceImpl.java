package com.project.redis_project.Service.products;

import com.project.redis_project.Dto.ProductDto.ProductDto;
import com.project.redis_project.Entities.Product;
import com.project.redis_project.Repositries.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
        Product product = Product.builder()
                .productName(productDto.productName())
                .description(productDto.description())
                .price(productDto.price())
                .stock(productDto.stock())
                .category(productDto.category())
                        .build();

        Product savedProduct = productRepo.save(product);
        return new ProductDto(savedProduct.getProductId(),
                savedProduct.getProductName(),
                savedProduct.getDescription(),
                savedProduct.getPrice(),
                savedProduct.getStock(),
                savedProduct.getCategory());
    }
    @Cacheable(value = "products", key = "#id")
    @Override
    public ProductDto getProduct(UUID id) {
        log.info("Cache miss! Fetching product from the database for ID: {}", id);
        slowDbCall();
        Product product = productRepo.findById(id).
                orElseThrow(
                        () -> {
                            log.error("product does not exist with id: {}", id);
                            return new IllegalArgumentException("product not found");
                        }
                );

        return new ProductDto(product.getProductId(), product.getProductName(), product.getDescription(), product.getPrice(), product.getStock(),
                product.getCategory());

    }

    private void slowDbCall() {
        try {
                Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
