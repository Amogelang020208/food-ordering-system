package com.jumpstart.food_ordering_system.repository;

import com.jumpstart.food_ordering_system.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface is responsible for database operations for Category
// JpaRepository provides built-in methods like findAll, save, delete
public interface CategoryRepository extends JpaRepository<Category, Long> {

}