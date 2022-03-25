package com.example.apelsin_rest_api.dto;

import com.example.apelsin_rest_api.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private UUID customerId;
    private Date date;
}
