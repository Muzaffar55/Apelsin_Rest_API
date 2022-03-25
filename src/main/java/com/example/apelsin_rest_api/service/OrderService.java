package com.example.apelsin_rest_api.service;

import com.example.apelsin_rest_api.dto.ApiResponse;
import com.example.apelsin_rest_api.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    public ApiResponse add(OrderDTO dto) {
        return null;
    }

    public ApiResponse edit(Integer id, OrderDTO orderDTO) {
        return null;
    }
}
