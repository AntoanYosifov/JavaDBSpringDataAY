package com.example.springdataexercise.services;

import com.example.springdataexercise.entities.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();
}
