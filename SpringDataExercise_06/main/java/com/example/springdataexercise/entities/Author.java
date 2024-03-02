package com.example.springdataexercise.entities;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.Set;

@Entity(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(this.books);
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Column(name = "last_name", nullable = false)
    private String lastName;
    @OneToMany(targetEntity = Book.class, mappedBy = "author")
    private Set<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}