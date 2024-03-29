package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> selectNameStartsWith(String startsWith) {
        return this.ingredientRepository.findByNameStartingWith(startsWith);
    }

    @Override
    public List<Ingredient> selectByNamesIn(List<String> names) {
        return this.ingredientRepository.findByNameIsIn(names);
    }
}
