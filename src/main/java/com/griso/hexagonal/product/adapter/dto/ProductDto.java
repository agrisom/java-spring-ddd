package com.griso.hexagonal.product.adapter.dto;

import lombok.Data;

@Data
public class ProductDto {

    private String id;
    private String name;
    private String image;
    private String description;
    private double price;

}
