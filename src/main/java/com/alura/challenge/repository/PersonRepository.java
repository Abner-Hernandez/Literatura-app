package com.alura.challenge.repository;

import com.alura.challenge.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.birthYear = :birthYear AND p.deathYear = :deathYear AND p.name = :name")
    public Optional<Person> getPerson(String name, long birthYear, long deathYear);

}
