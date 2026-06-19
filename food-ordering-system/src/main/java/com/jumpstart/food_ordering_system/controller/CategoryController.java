package com.jumpstart.food_ordering_system.controller;

import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.response.Response;
import com.jumpstart.food_ordering_system.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public Response<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return Response.success(categories, "Categories retrieved successfully");
    }
}