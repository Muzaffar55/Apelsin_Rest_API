package com.example.apelsin_rest_api.controller;

import com.example.apelsin_rest_api.dto.ApiResponse;
import com.example.apelsin_rest_api.dto.OrderDTO;
import com.example.apelsin_rest_api.entity.Order;
import com.example.apelsin_rest_api.repository.OrderRepository;
import com.example.apelsin_rest_api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {
    final OrderRepository orderRepository;

    final OrderService orderService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Order> all = orderRepository.findAllByActiveTrue();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        Optional<Order> byId = orderRepository.findById(id);

        return ResponseEntity.status(byId.isEmpty() ?
                HttpStatus.NOT_FOUND : HttpStatus.OK).body(byId.orElse(new Order()));

    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody OrderDTO dto) {
        ApiResponse response = orderService.add(dto);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody OrderDTO orderDTO) {
        ApiResponse response = orderService.edit(id, orderDTO);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Optional<Order> byId = orderRepository.findById(id);
        if (byId.isEmpty()) return ResponseEntity.status(404).body("NOT FOUND");
        Order order = byId.get();
        orderRepository.save(order);
        return ResponseEntity.ok().body("DELETED!");
    }
}
