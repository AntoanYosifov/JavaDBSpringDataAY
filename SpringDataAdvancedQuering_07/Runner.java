package com.example.advquerying;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {

    private final ShampooService shampooService;

    @Autowired
    public Runner(ShampooService shampooService) {
        this.shampooService = shampooService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        double price = Double.parseDouble(scanner.nextLine());

        //_01_selectShampooBySize(sizeString);
        // _02_selectShampoosBySizeOrLabel(sizeString, labelId);
        _03_selectShampoosByPrice(price);


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
}
