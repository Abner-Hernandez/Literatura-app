package com.alura.challenge.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record DatosBook(
        long id,
        String title,
        List<String> subjects,
        List<DatosPerson> authors,
        List<DatosPerson> translators,
        List<String> bookshelves,
        List<String> languages,
        Boolean copyright,
        String media_type,
        Map<String, String> formats,
        Long download_count
) {
}
