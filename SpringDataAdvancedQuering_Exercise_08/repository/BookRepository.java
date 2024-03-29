package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);
    @Query("SELECT b.title FROM Book b " +
            "WHERE b.ageRestriction = :ageRestriction")
    List<String> findAllTitlesByAgeRestriction(AgeRestriction ageRestriction);
    List<Book> findByEditionTypeAndCopiesLessThan(EditionType type, int numCopies);
    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lessThanPrice, BigDecimal greaterThanPrice);
    @Query("SELECT b.title FROM Book b " +
            "WHERE YEAR(b.releaseDate)  <> :year")
    List<String> findBookTitlesNotReleasedInAGivenYear(String year);
    List<Book> findByTitleContainingIgnoreCase(String pattern);
    List<Book> findByAuthorLastNameStartsWith(String pattern);
    @Query("SELECT COUNT(b.id) FROM Book b " +
            "WHERE LENGTH(b.title) > :length")
    int  findCountByTitleLengthLongerThan(int length);


}
