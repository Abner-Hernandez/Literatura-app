package com.alura.challenge.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private long birthYear;
    @Column(unique = true)
    private long deathYear;

    @ManyToMany(mappedBy = "authors") // Para autores
    private List<Book> authoredBooks = new ArrayList<>();

    @ManyToMany(mappedBy = "translators") // Para traductores
    private List<Book> translatedBooks = new ArrayList<>();

    // Constructor
    public Person() {}

    public Person(String name, long birthYear, long deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBirthYear() {
        return birthYear;
    }

    public long getDeathYear() {
        return deathYear;
    }

    public void setBirthYear(long birthYear) {
        this.birthYear = birthYear;
    }

    public void setDeathYear(long deathYear) {
        this.deathYear = deathYear;
    }

    public List<Book> getAuthoredBooks() {
        return authoredBooks;
    }

    public void setAuthoredBooks(List<Book> authoredBooks) {
        this.authoredBooks = authoredBooks;
    }

    public List<Book> getTranslatedBooks() {
        return translatedBooks;
    }

    public void setTranslatedBooks(List<Book> translatedBooks) {
        this.translatedBooks = translatedBooks;
    }

    @Override
    public String toString() {
        return String.format("""
            name: %s
            birthYear: %d
            deathYear: %d
            """,
                name, birthYear, deathYear);
    }
}