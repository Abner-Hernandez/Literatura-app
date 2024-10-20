package com.alura.challenge.service;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Arrays;
import java.util.List;

public class ConvierteDatos implements IConvierteDatos{
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        String resultsJson = jsonObject.getAsJsonArray("results").toString();
        return new Gson().fromJson(resultsJson, clase);
    }

    @Override
    public <T> List<T> obtenerDatosListado(String json, Class<T[]> clase) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        String resultsJson = jsonObject.getAsJsonArray("results").toString();
        return Arrays.asList(new Gson().fromJson(resultsJson, clase));
    }
}
