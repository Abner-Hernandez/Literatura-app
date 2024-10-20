package com.alura.challenge.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class PersonAdapter implements JsonSerializer<Person> {
    @Override
    public JsonElement serialize(Person src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Nombre", src.getName());
        jsonObject.addProperty("BirthYear", src.getBirthYear());
        jsonObject.addProperty("DeathYear", src.getDeathYear());
        return jsonObject;
    }
}
