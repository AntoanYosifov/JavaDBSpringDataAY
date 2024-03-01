package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {
    private final ShampooRepository shampooRepository;

    @Autowired
    public Runner(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String sizeName = scanner.nextLine();
        Size size = Size.valueOf(sizeName);

        this.shampooRepository.findBySizeOrderById(size)
                .forEach(System.out::println);


    }
}
