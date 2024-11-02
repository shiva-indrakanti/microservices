package com.ms.product_service.controller;

import com.ms.product_service.constants.ProductConstants;
import com.ms.product_service.dto.ResponseDto;
import com.ms.product_service.dto.ProductResponseDto;
import com.ms.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createProduct(@RequestBody ProductResponseDto productResponseDto){
        productService.saveProduct(productResponseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(ProductConstants.STATUS_201,ProductConstants.MESSAGE_201));
    }

    @GetMapping("/all")
    public List<ProductResponseDto> getAllProducts(){
        List<ProductResponseDto> listOfProducts = productService.findAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(listOfProducts).getBody();
    }
}
