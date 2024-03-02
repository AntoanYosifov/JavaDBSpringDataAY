package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> selectNameStartsWith(String startsWith);
    List<Ingredient> selectByNamesIn(List<String> names);
}
