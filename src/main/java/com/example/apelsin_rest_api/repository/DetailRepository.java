package com.example.apelsin_rest_api.repository;

import com.example.apelsin_rest_api.entity.Category;
import com.example.apelsin_rest_api.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DetailRepository extends JpaRepository<Detail, Integer> {
}
