package com.example.apelsin_rest_api.repository;

import com.example.apelsin_rest_api.entity.Category;
import com.example.apelsin_rest_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface ProductRepository extends JpaRepository<Product, UUID> {
    
    List<Product> findAllByActiveTrue();

    List<Product> findAllByCategory_Id(Integer id);
}
