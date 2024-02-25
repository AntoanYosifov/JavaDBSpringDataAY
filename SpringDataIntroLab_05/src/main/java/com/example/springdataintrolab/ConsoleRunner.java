package com.example.springdataintrolab;

import com.example.springdataintrolab.models.User;
import com.example.springdataintrolab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User first = new User("dragan", 35);
        userService.registerUser(first);

        User second = new User("dragan", 35);
        userService.registerUser(second);

    }
}
