package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    @Autowired
    public Runner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<String> ingredientNamesList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String ingredientName = scanner.nextLine();
            ingredientNamesList.add(ingredientName);
        }
        _05_selectIngredientsByNamesInAList(ingredientNamesList);

        //_01_selectShampooBySize(sizeString);
        // _02_selectShampoosBySizeOrLabel(sizeString, labelId);
       // _03_selectShampoosByPrice(price);
       // _04_selectIngredientsByName(ingredientStartsWith);


    }

    private void _01_selectShampooBySize(String sizeString) {
        Size size = Size.valueOf(sizeString);

        List<Shampoo> shampoos = this.shampooService.selectShampooBySize(size);
        shampoos.forEach(System.out::println);
    }

    private void _02_selectShampoosBySizeOrLabel(String sizeString, int labelId) {
        Size size = Size.valueOf(sizeString);

        List<Shampoo> shampoos = this.shampooService.selectBySizeOrLabelId(size, labelId);
        shampoos.forEach(System.out::println);
    }

    private void _03_selectShampoosByPrice(double price) {
        BigDecimal bigDecimalPrice = BigDecimal.valueOf(price);

        List<Shampoo> shampoos = this.shampooService.selectMoreExpensiveThan(bigDecimalPrice);
        shampoos.forEach(System.out::println);
    }
    private void _04_selectIngredientsByName(String startsWith){
        List<Ingredient> ingredients = this.ingredientService.selectNameStartsWith(startsWith);
        ingredients.forEach(System.out::println);
    }
    private void _05_selectIngredientsByNamesInAList(List<String> names){
        List<Ingredient> ingredients = this.ingredientService.selectByNamesIn(names);
        ingredients.forEach(System.out::println);
    }
}
