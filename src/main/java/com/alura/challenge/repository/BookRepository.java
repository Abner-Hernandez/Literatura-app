package com.alura.challenge.repository;

import com.alura.challenge.model.Book;
import com.alura.challenge.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT DISTINCT a FROM Book b JOIN b.authors a")
    List<Person> findAllAuthors();

    @Query("SELECT DISTINCT a FROM Book b JOIN b.authors a WHERE :year BETWEEN a.birthYear AND a.deathYear")
    List<Person> findAuthorsLivesYear(int year);

}
