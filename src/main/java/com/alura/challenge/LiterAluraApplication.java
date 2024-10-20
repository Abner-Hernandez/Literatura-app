package com.alura.challenge;

import com.alura.challenge.principal.Principal;
import com.alura.challenge.repository.BookRepository;
import com.alura.challenge.repository.LanguageRepository;
import com.alura.challenge.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	LanguageRepository languageRepository;

	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(bookRepository, languageRepository, personRepository);
		principal.muestraElMenu();
	}

}
