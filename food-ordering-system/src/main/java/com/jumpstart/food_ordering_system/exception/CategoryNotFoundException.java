package com.jumpstart.food_ordering_system.exception;

// This class is a custom exception used when a category is not found
// Custom exceptions make error handling more specific and meaningful
public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }
}