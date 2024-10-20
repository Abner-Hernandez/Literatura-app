package com.alura.challenge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookshelves")
public class Bookshelf {

    @Id
    private String name;

    @ManyToMany(mappedBy = "bookshelves")
    private List<Book> books = new ArrayList<>();

    // Constructor
    public Bookshelf() {}

    public Bookshelf(String name) {
        this.name = name;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}