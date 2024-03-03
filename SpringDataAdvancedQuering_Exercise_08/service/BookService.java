package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllTitlesByAgeRestriction(String ageRestriction);

    List<String> findAllTitlesByEditionTypeAndCopies(EditionType type, int copies);

    List<Book> findAllByPriceLessThanAndPriceHigherThan(double lessThanPrice, double higherThanPrice);
    List<String> findTitlesReleasedNotInYear(String year);
    List<Book> findAllBooksReleasedBeforeYear(LocalDate releasedDate);
    List<String> findAllTitlesContainingAString(String pattern);
    List<String> findTitlesByAuthorFirstNameStartsWith(String pattern);

}
