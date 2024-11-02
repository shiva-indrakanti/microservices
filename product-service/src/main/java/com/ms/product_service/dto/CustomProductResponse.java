package com.ms.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomProductResponse {

    private Integer statusCode;
    private String statusMessage;
    private ProductResponseDto productResponseDto;

}
