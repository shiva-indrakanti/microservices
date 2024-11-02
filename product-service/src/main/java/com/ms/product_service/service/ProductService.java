package com.ms.product_service.service;

import com.ms.product_service.dto.ProductResponseDto;
import com.ms.product_service.exception.ProductAlreadyExistsException;
import com.ms.product_service.model.Product;
import com.ms.product_service.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void saveProduct(ProductResponseDto productResponseDto) {
        Optional<Product> alreadyExists = productRepo.findByName(productResponseDto.getName());
        if(alreadyExists.isPresent()) {
            throw new ProductAlreadyExistsException("Product already exists in system. Please check the product name");
        }
        Product product = new Product();
        product.setId(productResponseDto.getId());
        product.setName(productResponseDto.getName());
        product.setDescription(productResponseDto.getDescription());
        product.setPrice(productResponseDto.getPrice());
        productRepo.save(product);
    }
}
