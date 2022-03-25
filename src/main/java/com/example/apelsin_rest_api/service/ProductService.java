package com.example.apelsin_rest_api.service;

import com.example.apelsin_rest_api.dto.ApiResponse;
import com.example.apelsin_rest_api.dto.ProductDTO;
import com.example.apelsin_rest_api.repository.CategoryRepository;
import com.example.apelsin_rest_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    final CategoryRepository categoryRepository;


    public ApiResponse getAll() {
        return null;
    }

    public ApiResponse add(ProductDTO dto) {
        return null;
    }

    public ApiResponse edit(Integer id, ProductDTO productDTO) {
        return null;
    }
}
