package com.example.apelsin_rest_api.controller;

import com.example.apelsin_rest_api.dto.ApiResponse;
import com.example.apelsin_rest_api.dto.ProductDTO;
import com.example.apelsin_rest_api.entity.Product;
import com.example.apelsin_rest_api.repository.ProductRepository;
import com.example.apelsin_rest_api.repository.ProductRepository;
import com.example.apelsin_rest_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    final ProductRepository productRepository;

    final ProductService productService;


    @GetMapping
    public HttpEntity<?> getAll() {
        List<Product> all = productRepository.findAllByActiveTrue();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable UUID id) {
        Optional<Product> byId = productRepository.findById(id);

        return ResponseEntity.status(byId.isEmpty() ?
                HttpStatus.NOT_FOUND : HttpStatus.OK).body(byId.orElse(new Product()));
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody ProductDTO dto) {
        ApiResponse response = productService.add(dto);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
        ApiResponse response = productService.edit(id, productDTO);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) return ResponseEntity.status(404).body("NOT FOUND");
        Product product = byId.get();
        product.setActive(false);
        productRepository.save(product);
        return ResponseEntity.ok().body("DELETED!");
    }

    @GetMapping("/change/{id}")
    public HttpEntity<?> changeActive(@PathVariable UUID id, @RequestParam boolean status) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct.get();
        product.setActive(!product.isActive());
        productRepository.save(product);
        return ResponseEntity.ok().body(optionalProduct.orElseThrow(RuntimeException::new));
    }

    @GetMapping("/forClient")
    public HttpEntity<?> getAllForClient() {
        ApiResponse response = productService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/byProductId/{id}")
    public HttpEntity<?> getAllByProduct(@PathVariable Integer id) {
        return ResponseEntity.ok().body(productRepository.findAllByCategory_Id(id));
    }
}
