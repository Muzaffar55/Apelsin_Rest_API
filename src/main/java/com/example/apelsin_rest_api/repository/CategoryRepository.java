package com.example.apelsin_rest_api.repository;

import com.example.apelsin_rest_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByActiveTrue();
}
