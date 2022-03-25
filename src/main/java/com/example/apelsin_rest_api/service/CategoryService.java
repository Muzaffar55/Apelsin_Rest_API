package com.example.apelsin_rest_api.service;


import com.example.apelsin_rest_api.dto.ApiResponse;
import com.example.apelsin_rest_api.entity.Category;
import com.example.apelsin_rest_api.entity.Product;
import com.example.apelsin_rest_api.repository.CategoryRepository;
import com.example.apelsin_rest_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    final ProductRepository productRepository;

    final CategoryRepository categoryRepository;

    public ApiResponse add( Category added) {

        Category category = new Category();
        category.setName(added.getName());


        categoryRepository.save(category);
        return new ApiResponse("Added", true);
    }


    public ApiResponse edit(Integer id, Category edited) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) return new ApiResponse("Category Not found!", false);

        Category category = byId.get();

        category.setName(edited.getName());


        categoryRepository.save(category);
        return new ApiResponse("Edited", true);
    }

    public ApiResponse getAll() {
        List<Category> all = categoryRepository.findAllByActiveTrue();

//        List<CategoryDTO> collect = all.stream().map(this::categoryToCategoryDTO).collect(Collectors.toList());

        return new ApiResponse("Mana", true);
    }

//    private CategoryDTO categoryToCategoryDTO(Category category) {
//
//        return new CategoryDTO(
//                category.setName(category.getName()
//        )
//    }


}
