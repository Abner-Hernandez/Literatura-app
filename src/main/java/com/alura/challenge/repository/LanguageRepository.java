package com.alura.challenge.repository;

import com.alura.challenge.model.Book;
import com.alura.challenge.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, String> {

    @Query("SELECT DISTINCT b FROM Language l JOIN l.books b WHERE l.name = :language")
    List<Book> findBooksByLanguage(String language);
}
