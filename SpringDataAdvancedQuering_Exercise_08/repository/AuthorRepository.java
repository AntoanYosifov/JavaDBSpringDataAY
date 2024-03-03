package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.AuthorNameAndTotalCopies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY size(a.books)  DESC")
    List<Author> findAllByBooksSizeDESC();

    List<Author> findAllByFirstNameEndsWith(String letter);
    @Query("SELECT a.firstName as firstName, a.lastName as lastName, sum(b.copies) as totalCopies FROM Author a  " +
            "JOIN a.books b " +
            "GROUP BY b.author " +
            "order by totalCopies desc")
    List<AuthorNameAndTotalCopies> getWithTotalCopies();
}
