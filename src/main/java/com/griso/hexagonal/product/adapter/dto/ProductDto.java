package com.griso.hexagonal.product.adapter.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "product")
public class ProductDto {

    @Id
    private String id;
    private String name;
    private String image;
    private String description;
    private double price;

}
