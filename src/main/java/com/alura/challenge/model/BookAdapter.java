package com.alura.challenge.model;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;

public class BookAdapter implements JsonSerializer<Book> {

    @Override
    public JsonElement serialize(Book src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", src.getId());
        jsonObject.addProperty("title", src.getTitle());

        // Serializar Subjects
        JsonArray subjectsArray = new JsonArray();
        for (Subject subject : src.getSubjects()) {
            subjectsArray.add(subject.getName());
        }
        jsonObject.add("subjects", subjectsArray);

        // Serializar authors
        JsonArray authorsArray = new JsonArray();
        for (Person author : src.getAuthors()) {
            JsonObject authorJson = new JsonObject();
            authorJson.addProperty("name", author.getName());
            authorJson.addProperty("BirthYear", author.getBirthYear());
            authorJson.addProperty("DeathYear", author.getDeathYear());
            authorsArray.add(authorJson);
        }
        jsonObject.add("authors", authorsArray);

        // Serializar translators
        JsonArray translatorsArray = new JsonArray();
        for (Person translator : src.getTranslators()) {
            JsonObject translatorJson = new JsonObject();
            translatorJson.addProperty("Name", translator.getName());
            translatorJson.addProperty("BirthYear", translator.getBirthYear());
            translatorJson.addProperty("DeathYear", translator.getDeathYear());
            translatorsArray.add(translatorJson);
        }
        jsonObject.add("translators", translatorsArray);

        // Serializar bookshelves
        JsonArray bookshelvesArray = new JsonArray();
        for (Bookshelf bookshelf : src.getBookshelves()) {
            bookshelvesArray.add(bookshelf.getName());
        }
        jsonObject.add("bookshelves", bookshelvesArray);

        // Serializar languages
        JsonArray languagesArray = new JsonArray();
        for (Language language : src.getLanguages()) {
            languagesArray.add(language.toString());
        }
        jsonObject.add("languages", languagesArray);

        // Agregar otros campos
        jsonObject.addProperty("copyright", src.isCopyright());
        jsonObject.addProperty("media_type", src.getMediaType());

        // Serializar formats
        JsonObject formatsObject = new JsonObject();
        for (Map.Entry<String, String> entry : src.getFormats().entrySet()) {
            formatsObject.addProperty(entry.getKey(), entry.getValue());
        }
        jsonObject.add("formats", formatsObject);

        jsonObject.addProperty("download_count", src.getDownloadCount());

        return jsonObject;
    }
}
