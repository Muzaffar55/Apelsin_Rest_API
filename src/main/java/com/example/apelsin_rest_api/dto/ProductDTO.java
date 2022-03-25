package com.example.apelsin_rest_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private String name;
    private String description;
    private Integer price;
    private String photo;
}
