package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.exception.CategoryNotFoundException;
import com.jumpstart.food_ordering_system.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// This class implements the CategoryService interface
// It contains the business logic for retrieving categories
@Service
public class CategoryServiceImpl implements CategoryService {

    // Inject the CategoryRepository
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        // Retrieve all categories from the database
        List<Category> categories = categoryRepository.findAll();

        // Convert Category entities to CategoryDto objects
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categories) {
            CategoryDto dto = new CategoryDto();
            dto.setId(category.getId());
            dto.setName(category.getName());
            categoryDtos.add(dto);
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        // Find the category by id, or throw an exception if it doesn't exist
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));

        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    @Override
    public CategoryDto addCategory(CategoryDto dto) {
        // Map the incoming DTO to a new Category entity
        Category category = new Category();
        category.setName(dto.getName());

        // Save the entity to the database
        Category savedCategory = categoryRepository.save(category);

        // Map the saved entity back to a DTO (now with its generated id)
        CategoryDto savedDto = new CategoryDto();
        savedDto.setId(savedCategory.getId());
        savedDto.setName(savedCategory.getName());
        return savedDto;
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto dto) {
        // Find the existing category, or throw an exception if it doesn't exist
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));

        // Update the name and save
        category.setName(dto.getName());
        Category updatedCategory = categoryRepository.save(category);

        // Map the updated entity back to a DTO
        CategoryDto updatedDto = new CategoryDto();
        updatedDto.setId(updatedCategory.getId());
        updatedDto.setName(updatedCategory.getName());
        return updatedDto;
    }
}