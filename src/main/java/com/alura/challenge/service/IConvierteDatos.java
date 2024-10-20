package com.alura.challenge.service;

import java.util.List;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
    <T> List<T> obtenerDatosListado(String json, Class<T[]> clase);
}
