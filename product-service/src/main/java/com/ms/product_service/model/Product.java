package com.ms.product_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "sku_code",unique = true, nullable = false)
    private String skuCode;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_desc")
    private String description;


    @Column(name = "price")
    private double price;
}
