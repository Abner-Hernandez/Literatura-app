package com.alura.challenge.principal;

import com.alura.challenge.model.*;
import com.alura.challenge.repository.BookRepository;
import com.alura.challenge.repository.LanguageRepository;
import com.alura.challenge.repository.PersonRepository;
import com.alura.challenge.service.ConsumoAPI;
import com.alura.challenge.service.ConvierteDatos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private final ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private final ConvierteDatos conversor = new ConvierteDatos();
    private BookRepository bookRepository;
    private LanguageRepository languageRepository;
    private PersonRepository personRepository;
    Gson gson;
    Gson gsonBook;
    Gson gsonPerson;

    public Principal(BookRepository bookRepository, LanguageRepository languageRepository, PersonRepository personRepository) {
        this.bookRepository = bookRepository;
        this.languageRepository = languageRepository;
        this.personRepository = personRepository;
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        this.gsonBook = new GsonBuilder()
                .registerTypeAdapter(Book.class, new BookAdapter())
                .setPrettyPrinting()
                .create();
        this.gsonPerson = new GsonBuilder()
                .registerTypeAdapter(Person.class, new PersonAdapter())
                .setPrettyPrinting()
                .create();

    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                     ------------------------------------------------------
                    |    1 - Buscar Libro por titulo                       |
                    |    2 - Listar libros registrados                     |
                    |    3 - Listar autores registrados                    |
                    |    4 - Listar autores vivos en un determinado año    |
                    |    5 - listar libros por idioma                      |
                    |                                                      |
                    |    0 - Salir                                         |
                     ------------------------------------------------------
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorNombre();
                    break;
                case 2:
                    getAllRegisteredBooks();
                    break;
                case 3:
                    getAllAuthors();
                    break;
                case 4:
                    getAuthorsAliveOnYear();
                    break;
                case 5:
                    getBooksByLanguage();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private List<DatosBook> getLibroPorNombre() {
        String nombreLibro = this.getUserValue("Escribe el titulo del libro que deseas buscar")
                .replace(" ", "%20");

        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + nombreLibro);
        return conversor.obtenerDatosListado(json, DatosBook[].class);
    }

    @Transactional
    private void buscarLibroPorNombre() {
        List<DatosBook> datos = getLibroPorNombre();
        System.out.println(gson.toJson(datos));
        datos.stream()
                .filter(book -> !bookRepository.existsById(book.id()))
                .forEach(book -> {
            Book libro = new Book(book, this.personRepository);
            bookRepository.save(libro);
        });
    }

    private void getAllRegisteredBooks() {
        System.out.println(gsonBook.toJson(bookRepository.findAll()));
    }

    private void getAllAuthors() {
        System.out.println(gsonPerson.toJson(bookRepository.findAllAuthors()));
    }

    private void getAuthorsAliveOnYear(){
        int year = -1;
        do {
            System.out.print("Introduce el año a consultar: ");
            year = teclado.nextInt();
        } while (year < 0);
        System.out.println(gsonPerson.toJson(bookRepository.findAuthorsLivesYear(year)));
    }

    private void getBooksByLanguage() {
        System.out.println(gsonBook.toJson(languageRepository.findBooksByLanguage(
                getUserValue("Ingrese el idioma a consultar")
        )));
    }

    private String getUserValue(String message) {
        String value;
        do {
            System.out.println(message);
            value = teclado.nextLine();
        } while (value.isEmpty());
        return value;
    }
}
