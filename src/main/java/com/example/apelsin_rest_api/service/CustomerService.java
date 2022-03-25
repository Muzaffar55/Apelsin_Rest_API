package com.example.apelsin_rest_api.service;

import com.example.apelsin_rest_api.dto.ApiResponse;
import com.example.apelsin_rest_api.entity.Customer;
import com.example.apelsin_rest_api.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    public ApiResponse add(Customer customer) {
        customerRepository.save(customer);
        return new ApiResponse("Added", true);
    }

    public ApiResponse edit(Integer id, Customer customer) {

        Optional<Customer> byId = customerRepository.findById(id);
        if (byId.isEmpty()) return new ApiResponse("Customer Not found!", false);

        Customer edited = byId.get();
        edited.setCountry(customer.getCountry());
        edited.setAddress(customer.getAddress());
        edited.setName(customer.getName());
        edited.setPhone(customer.getPhone());
        customerRepository.save(edited);

        return new ApiResponse("Edited", true);
    }
}
