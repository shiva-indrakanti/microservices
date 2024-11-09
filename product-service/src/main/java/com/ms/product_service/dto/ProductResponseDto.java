package com.ms.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {

    private String skuCode;

    private String name;

    private String description;

    private double price;

}
