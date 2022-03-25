package com.example.apelsin_rest_api.service;

import com.example.apelsin_rest_api.dto.ApiResponse;
import com.example.apelsin_rest_api.dto.PaymentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    public ApiResponse add(PaymentDTO dto) {
        return null;
    }

    public ApiResponse edit(Integer id, PaymentDTO paymentDTO) {
        return null;
    }
}
