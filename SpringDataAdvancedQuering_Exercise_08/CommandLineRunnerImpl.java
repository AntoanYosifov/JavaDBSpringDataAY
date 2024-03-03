package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
       String pattern = scanner.nextLine();

       // seedData();

        //printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
     //   printAllAuthorsAndNumberOfTheirBooks();
        //printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
       // _01_printAllBookTitlesByAgeRestriction(ageRestriction);
      //  _02_printTheTitlesOfGoldEditionBooks();
        //_03_printTitlesAndPricesOfBooks();
       // _04_printTitlesNotReleasedBooks(year);
        //_05_printBooksReleaseBeforeDate(releaseDate);
        //_06_printAllAuthorsFirstNamesEndsWith(letter);
        //_07_printAllTitlesBooksContainingString(pattern);
        _08_printAllTitlesWithAuthorFirstNameStartsWith(pattern);


    }
    private void _08_printAllTitlesWithAuthorFirstNameStartsWith(String pattern){
        this.bookService.findTitlesByAuthorFirstNameStartsWith(pattern)
                .forEach(System.out::println);
    }
    private void _07_printAllTitlesBooksContainingString(String pattern){
        this.bookService.findAllTitlesContainingAString(pattern)
                .forEach(System.out::println);
    }
    private void _06_printAllAuthorsFirstNamesEndsWith(String letter){
        this.authorService.getAllFirstNamesEndWith(letter)
                .forEach(System.out::println);
    }
    private void _05_printBooksReleaseBeforeDate(String releaseDateString){
        String[] dateTokens = releaseDateString.split("-");
        int dayOfMonth = Integer.parseInt(dateTokens[0]);
        int month = Integer.parseInt(dateTokens[1]);
        int year = Integer.parseInt(dateTokens[2]);

        LocalDate releaseDate = LocalDate.of(year, month, dayOfMonth);

        this.bookService.findAllBooksReleasedBeforeYear(releaseDate)
                .forEach(b-> System.out.printf("%s %s %s\n", b.getTitle(), b.getEditionType().name(),
                        b.getPrice()));
    }
    private void _04_printTitlesNotReleasedBooks(String year){
        this.bookService.findTitlesReleasedNotInYear(year)
                .forEach(System.out::println);
    }
    private void _03_printTitlesAndPricesOfBooks(){
        this.bookService.findAllByPriceLessThanAndPriceHigherThan(5, 40)
                .forEach(b-> System.out.printf("%s - $%s\n", b.getTitle(), b.getPrice()));
    }
    private void _02_printTheTitlesOfGoldEditionBooks(){
        this.bookService.findAllTitlesByEditionTypeAndCopies(EditionType.GOLD, 5000)
                .forEach(System.out::println);
    }

    private void _01_printAllBookTitlesByAgeRestriction(String restriction){
        this.bookService.findAllTitlesByAgeRestriction(restriction)
                .forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
