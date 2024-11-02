package com.ms.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomProductResponse {

    private String statusCode;
    private String statusMessage;
    private ProductResponseDto productResponseDto;

}
