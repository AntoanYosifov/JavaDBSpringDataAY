package com.example.springdataexercise;

import com.example.springdataexercise.entities.Author;
import com.example.springdataexercise.entities.Book;
import com.example.springdataexercise.repositories.AuthorRepository;
import com.example.springdataexercise.repositories.BookRepository;
import com.example.springdataexercise.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // this.seedService.seedAuthors();
        // this.seedService.seedCategories();

        //this.seedService.seedAll();
        //_01_booksAfter2000();
        _02_authorsWithBooksBefore1990();

    }
    private void _01_booksAfter2000(){
        LocalDate year2000 = LocalDate.of(2000, 1 , 1);

        List<Book> books = this.bookRepository.findByReleaseDateAfter(year2000);

        books.forEach(b-> System.out.println(b.getReleaseDate() + " " + b.getTitle()));
    }
    private void _02_authorsWithBooksBefore1990(){
        LocalDate year1990 = LocalDate.of(1990, 1, 1);

        List<Author> authors = this.authorRepository.findDistinctByBooksReleaseDateBefore(year1990);

        authors.forEach(a-> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }
}
