package com.ms.product_service.service;

import com.ms.product_service.dto.ProductResponseDto;
import com.ms.product_service.exception.ProductAlreadyExistsException;
import com.ms.product_service.exception.ProductNotFoundException;
import com.ms.product_service.model.Product;
import com.ms.product_service.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void saveProduct(ProductResponseDto productResponseDto) {
        Product alreadyExists = productRepo
                .findByUniqueCode(productResponseDto.getUniqueCode())
                .orElse(null);

        if (alreadyExists != null) {
            throw new ProductAlreadyExistsException("Product already exists in system. Please check the product code: " + productResponseDto.getUniqueCode());
        }
        Product product = new Product();
        product.setUniqueCode(productResponseDto.getUniqueCode());
        product.setName(productResponseDto.getName());
        product.setDescription(productResponseDto.getDescription());
        product.setPrice(productResponseDto.getPrice());
        productRepo.save(product);
    }

    public List<ProductResponseDto> findAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream()
                .map(product -> new ProductResponseDto(product.getUniqueCode(),product.getName(),product.getDescription(),product.getPrice()))
                .toList();
    }

    public ProductResponseDto findByUniqueCode(long code) {
        Product product = productRepo
                .findByUniqueCode(code)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with code: " + code));

        ProductResponseDto productResponse = new ProductResponseDto();
        productResponse.setUniqueCode(product.getUniqueCode());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }
}
