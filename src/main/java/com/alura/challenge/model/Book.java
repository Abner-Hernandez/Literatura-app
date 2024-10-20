package com.alura.challenge.model;

import com.alura.challenge.repository.PersonRepository;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    private Long id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Person> authors;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Person> translators;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Subject> subjects;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Bookshelf> bookshelves;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Language> languages;

    private boolean copyright;
    private String mediaType;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_formats", joinColumns = @JoinColumn(name = "book_id"))
    @MapKeyColumn(name = "format_type")
    @Column(name = "format_value")
    private Map<String, String> formats = new HashMap<>();

    private long downloadCount;

    // Constructor
    public Book() {}

    public Book(DatosBook datosBook, PersonRepository personRepository) {
        this.id = datosBook.id();
        this.title = datosBook.title();
        this.authors = new ArrayList<>();
        datosBook.authors().forEach(author -> {
            Optional<Person> authorBook= personRepository.getPerson(author.name(), author.birth_year(), author.death_year());
            if (authorBook.isPresent()){
                this.authors.add(authorBook.get());
            } else {
                this.authors.add(
                        new Person(author.name(), author.birth_year(), author.death_year())
                );
            }
        });
        this.translators = new ArrayList<>();
        datosBook.translators().forEach(translator -> this.translators.add(
                new Person(translator.name(), translator.birth_year(), translator.birth_year())
        ));
        this.subjects = new ArrayList<>();
        datosBook.subjects().forEach(subject -> this.subjects.add(
                new Subject(subject)
        ));
        this.bookshelves = new ArrayList<>();
        datosBook.bookshelves().forEach(bookshelf -> this.bookshelves.add(
                new Bookshelf(bookshelf)
        ));
        this.languages = new ArrayList<>();
        datosBook.languages().forEach(language -> this.languages.add(
                new Language(language)
        ));
        this.copyright = datosBook.copyright();
        this.mediaType = datosBook.media_type();
        this.formats = datosBook.formats();
        this.downloadCount = datosBook.download_count();
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }

    public List<Person> getTranslators() {
        return translators;
    }

    public void setTranslators(List<Person> translators) {
        this.translators = translators;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Bookshelf> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<Bookshelf> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Map<String, String> getFormats() {
        return formats;
    }

    public void setFormats(Map<String, String> formats) {
        this.formats = formats;
    }

    public long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(long downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return String.format("""
            id: %d
            title: %s
            authors: %s
            translators: %s
            subjects: %s
            bookshelves: %s
            languages: %s
            copyright: %b
            mediaType: %s
            formats: %s
            downloadCount: %d
            """,
                id, title,
                authors,
                translators,
                subjects,
                bookshelves,
                languages,
                copyright,
                mediaType,
                formats,
                downloadCount);
    }

}