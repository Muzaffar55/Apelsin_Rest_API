package com.example.apelsin_rest_api.repository;

import com.example.apelsin_rest_api.entity.Category;
import com.example.apelsin_rest_api.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
}
