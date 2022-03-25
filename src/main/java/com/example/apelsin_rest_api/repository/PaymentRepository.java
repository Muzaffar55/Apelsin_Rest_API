package com.example.apelsin_rest_api.repository;

import com.example.apelsin_rest_api.entity.Category;
import com.example.apelsin_rest_api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    List<Payment> findAllByActiveTrue();
}
