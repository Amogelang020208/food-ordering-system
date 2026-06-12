package com.jumpstart.food_ordering_system.dto;

// This class is a Data Transfer Object (DTO)
// It is used to transfer data between layers without exposing the entity directly
public class CategoryDto {

    private Long id;
    private String name;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
