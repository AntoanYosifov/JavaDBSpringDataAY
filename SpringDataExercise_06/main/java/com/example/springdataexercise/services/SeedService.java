package com.example.springdataexercise.services;

import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface  SeedService {
    void seedAuthors() throws IOException;
    void seedCategories() throws IOException;
    void seedBooks() throws IOException;
    default void seedAll() throws IOException {
        seedAuthors();
        seedCategories();
        seedBooks();
    }

}
