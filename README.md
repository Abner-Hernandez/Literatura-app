# Gestor de Libros

Esta es una aplicación de consola en Java basada en Spring Boot que permite gestionar libros y autores. Utiliza la API de Gutendex para obtener información sobre libros.

## Requisitos

- **Java 11 o superior**
- **Spring Boot**
- **Base de Datos PostgreSQL**
- **Apache Maven**
- **Librerías necesarias**:
    - Spring Data JPA
    - PostgreSQL Driver

## Librerías Necesarias

Para la ejecución de la aplicacion es necesaria la instalación de las siguientes dependencias definidas en el archivo `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

Para instalar las dependencias con maven usar el siguiente comando de consola.

```bash
mvn install
```

## Configuración de Variables de Entorno

La aplicación utiliza variables de entorno para configurar la conexión a la base de datos.

```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
hibernate.dialect=org.hibernate.dialect.HSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

### Explicación de la Configuración

- **`spring.datasource.url`**: URL de conexión a la base de datos. Utiliza las variables de entorno para especificar el host y el nombre de la base de datos.
- **`spring.datasource.username`**: Nombre de usuario para acceder a la base de datos.
- **`spring.datasource.password`**: Contraseña correspondiente al usuario de la base de datos.
- **`spring.datasource.driver-class-name`**: Clase del driver JDBC para PostgreSQL.
- **`hibernate.dialect`**: Dialecto de Hibernate que permite ajustar las consultas SQL generadas.
- **`spring.jpa.hibernate.ddl-auto`**: Configuración que permite a Hibernate actualizar la estructura de la base de datos automáticamente.

## Uso de la Aplicación

1. **Inicia la Aplicación**:
Para ejecutar una aplicación es necesario:

1. **Compila y empaqueta el proyecto**:
   Estar en el directorio raíz del proyecto (donde está el archivo `pom.xml`). Ejecuta el siguiente comando:

   ```bash
   mvn clean package
   ```

   Esto compila el código y empaqueta la aplicación en un archivo JAR o WAR, dependiendo de tu configuración.

2. **Ejecuta la aplicación**:
   Si el resultado es un archivo JAR, puedes ejecutar la aplicación con el siguiente comando:

   ```bash
   java -jar target/LiterAluraApplication.jar
   ```

   Reemplaza `LiterAluraApplication.jar` con el nombre del archivo JAR generado en el directorio `target`.

También puedes usar el plugin de Spring Boot para ejecutar la aplicación directamente:

```bash
mvn spring-boot:run
```

Esto compilará y ejecutará la aplicación en un solo paso.
   Ejecuta la clase `LiterAluraApplication` para iniciar la aplicación en la consola.

3. **Menú Principal**:
    - **1. Buscar Libro por título**: Permite buscar libros usando su título.
    - **2. Listar libros registrados**: Muestra todos los libros almacenados en la base de datos.
    - **3. Listar autores registrados**: Muestra todos los autores almacenados.
    - **4. Listar autores vivos en un determinado año**: Permite consultar qué autores estaban vivos en un año específico.
    - **5. Listar libros por idioma**: Muestra los libros que están en un idioma específico.
    - **0. Salir**: Termina la ejecución de la aplicación.

4. **Buscar Libro**:
   - La búsqueda de libros se realiza en línea mediante la API de Gutendex, y los resultados se guardan en la base de datos si no están ya registrados.

## Ejemplo de Uso

```Text
 ------------------------------------------------------
|    1 - Buscar Libro por titulo                       |
|    2 - Listar libros registrados                     |
|    3 - Listar autores registrados                    |
|    4 - Listar autores vivos en un determinado año    |
|    5 - listar libros por idioma                      |
|                                                      |
|    0 - Salir                                         |
 ------------------------------------------------------

1
Escribe el titulo del libro que deseas buscar
The Scarlet Letter
[DatosBook[
id=25344, title=The Scarlet Letter,
subjects=[Adultery -- Fiction, Boston (Mass.) -- History -- Colonial period, ca. 1600-1775 -- Fiction, Clergy -- Fiction, Historical fiction, Illegitimate children -- Fiction, Married women -- Fiction, Psychological fiction, Puritans -- Fiction, Revenge -- Fiction, Triangles (Interpersonal relations) -- Fiction, Women immigrants -- Fiction],
authors=[DatosPerson[birth_year=1804, death_year=1864, name=Hawthorne, Nathaniel]],
translators=[],
bookshelves=[Banned Books from Anne Haight's list, Browsing: Culture/Civilization/Society, Browsing: Fiction, Browsing: History - American, Browsing: Literature], languages=[en], copyright=false, media_type=Text,
formats={text/html=https://www.gutenberg.org/ebooks/25344.html.images, application/epub+zip=https://www.gutenberg.org/ebooks/25344.epub3.images, application/x-mobipocket-ebook=https://www.gutenberg.org/ebooks/25344.kf8.images, text/plain; charset=us-ascii=https://www.gutenberg.org/ebooks/25344.txt.utf-8, application/rdf+xml=https://www.gutenberg.org/ebooks/25344.rdf, image/jpeg=https://www.gutenberg.org/cache/epub/25344/pg25344.cover.medium.jpg, application/octet-stream=https://www.gutenberg.org/files/25344/25344-0.zip},
download_count=45002],
DatosBook[
id=33, title=The Scarlet Letter,
subjects=[Adultery -- Fiction, Boston (Mass.) -- History -- Colonial period, ca. 1600-1775 -- Fiction, Clergy -- Fiction, Historical fiction, Illegitimate children -- Fiction, Married women -- Fiction, Psychological fiction, Puritans -- Fiction, Revenge -- Fiction, Triangles (Interpersonal relations) -- Fiction, Women immigrants -- Fiction],
authors=[DatosPerson[birth_year=1804, death_year=1864, name=Hawthorne, Nathaniel]],
translators=[],
bookshelves=[Browsing: Culture/Civilization/Society, Browsing: Fiction, Browsing: History - American, Browsing: Literature, Harvard Classics, Movie Books], languages=[en], copyright=false, media_type=Text, formats={text/html=https://www.gutenberg.org/ebooks/33.html.images, application/epub+zip=https://www.gutenberg.org/ebooks/33.epub3.images, application/x-mobipocket-ebook=https://www.gutenberg.org/ebooks/33.kf8.images, application/rdf+xml=https://www.gutenberg.org/ebooks/33.rdf, image/jpeg=https://www.gutenberg.org/cache/epub/33/pg33.cover.medium.jpg, application/octet-stream=https://www.gutenberg.org/files/33/33-0.zip, text/plain; charset=us-ascii=https://www.gutenberg.org/ebooks/33.txt.utf-8},
download_count=1506]]
 ------------------------------------------------------
|    1 - Buscar Libro por titulo                       |
|    2 - Listar libros registrados                     |
|    3 - Listar autores registrados                    |
|    4 - Listar autores vivos en un determinado año    |
|    5 - listar libros por idioma                      |
|                                                      |
|    0 - Salir                                         |
 ------------------------------------------------------

2
[id: 84
title: Frankenstein; Or, The Modern Prometheus
authors: [name: Shelley, Mary Wollstonecraft
birthYear: 1797
deathYear: 1851
]
translators: []
subjects: [Frankenstein's monster (Fictitious character) -- Fiction, Frankenstein, Victor (Fictitious character) -- Fiction, Gothic fiction, Horror tales, Monsters -- Fiction, Science fiction, Scientists -- Fiction]
bookshelves: [Browsing: Culture/Civilization/Society, Browsing: Fiction, Browsing: Gender & Sexuality Studies, Browsing: Literature, Browsing: Science-Fiction & Fantasy, Gothic Fiction, Movie Books, Precursors of Science Fiction, Science Fiction by Women]
languages: [en]
copyright: false
mediaType: Text
formats: {application/octet-stream=https://www.gutenberg.org/cache/epub/84/pg84-h.zip, text/html=https://www.gutenberg.org/ebooks/84.html.images, image/jpeg=https://www.gutenberg.org/cache/epub/84/pg84.cover.medium.jpg, application/rdf+xml=https://www.gutenberg.org/ebooks/84.rdf, application/x-mobipocket-ebook=https://www.gutenberg.org/ebooks/84.kf8.images, application/epub+zip=https://www.gutenberg.org/ebooks/84.epub3.images, text/plain; charset=us-ascii=https://www.gutenberg.org/ebooks/84.txt.utf-8}
downloadCount: 78467
, id: 41445
title: Frankenstein; Or, The Modern Prometheus
authors: [name: Shelley, Mary Wollstonecraft
birthYear: 1797
deathYear: 1851
]
translators: []
subjects: [Frankenstein's monster (Fictitious character) -- Fiction, Frankenstein, Victor (Fictitious character) -- Fiction, Gothic fiction, Horror tales, Monsters -- Fiction, Science fiction, Scientists -- Fiction]
bookshelves: [Browsing: Fiction, Browsing: Gender & Sexuality Studies, Browsing: Literature, Browsing: Science-Fiction & Fantasy, Precursors of Science Fiction, Science Fiction by Women]
languages: [en]
copyright: false
mediaType: Text
formats: {application/octet-stream=https://www.gutenberg.org/files/41445/41445-0.zip, text/html=https://www.gutenberg.org/ebooks/41445.html.images, image/jpeg=https://www.gutenberg.org/cache/epub/41445/pg41445.cover.medium.jpg, application/rdf+xml=https://www.gutenberg.org/ebooks/41445.rdf, application/x-mobipocket-ebook=https://www.gutenberg.org/ebooks/41445.kf8.images, application/epub+zip=https://www.gutenberg.org/ebooks/41445.epub3.images, text/plain; charset=us-ascii=https://www.gutenberg.org/ebooks/41445.txt.utf-8}
downloadCount: 12661
, id: 42324
title: Frankenstein; Or, The Modern Prometheus
authors: [name: Shelley, Mary Wollstonecraft
birthYear: 1797
deathYear: 1851
]
translators: []
subjects: [Frankenstein's monster (Fictitious character) -- Fiction, Frankenstein, Victor (Fictitious character) -- Fiction, Gothic fiction, Horror tales, Monsters -- Fiction, Science fiction, Scientists -- Fiction]
bookshelves: [Browsing: Fiction, Browsing: Science-Fiction & Fantasy, Precursors of Science Fiction, Science Fiction by Women]
languages: [en]
copyright: false
mediaType: Text
formats: {text/plain; charset=iso-8859-1=https://www.gutenberg.org/files/42324/42324-8.txt, application/octet-stream=https://www.gutenberg.org/cache/epub/42324/pg42324-h.zip, text/html=https://www.gutenberg.org/ebooks/42324.html.images, image/jpeg=https://www.gutenberg.org/cache/epub/42324/pg42324.cover.medium.jpg, application/rdf+xml=https://www.gutenberg.org/ebooks/42324.rdf, application/x-mobipocket-ebook=https://www.gutenberg.org/ebooks/42324.kf8.images, application/epub+zip=https://www.gutenberg.org/ebooks/42324.epub3.images, text/plain; charset=us-ascii=https://www.gutenberg.org/ebooks/42324.txt.utf-8, text/html; charset=iso-8859-1=https://www.gutenberg.org/files/42324/42324-h/42324-h.htm}
downloadCount: 8891
, id: 20038
title: Frankenstein; Or, The Modern Prometheus
authors: [name: Shelley, Mary Wollstonecraft
birthYear: 1797
deathYear: 1851
]
translators: []
subjects: [Frankenstein's monster (Fictitious character) -- Fiction, Frankenstein, Victor (Fictitious character) -- Fiction, Gothic fiction, Horror tales, Monsters -- Fiction, Science fiction, Scientists -- Fiction]
bookshelves: [Browsing: Fiction, Browsing: Literature, Browsing: Science-Fiction & Fantasy, Movie Books, Precursors of Science Fiction, Science Fiction by Women]
languages: [en]
copyright: false
mediaType: Sound
formats: {audio/ogg=https://www.gutenberg.org/files/20038/ogg/20038-01.ogg, text/html=https://www.gutenberg.org/files/20038/20038-index.html, application/rdf+xml=https://www.gutenberg.org/ebooks/20038.rdf, audio/mp4=https://www.gutenberg.org/files/20038/m4b/20038-01.m4a, audio/mpeg=https://www.gutenberg.org/files/20038/mp3/20038-01.mp3, text/plain=https://www.gutenberg.org/files/20038/20038-readme.txt}
downloadCount: 784
]
 ------------------------------------------------------
|    1 - Buscar Libro por titulo                       |
|    2 - Listar libros registrados                     |
|    3 - Listar autores registrados                    |
|    4 - Listar autores vivos en un determinado año    |
|    5 - listar libros por idioma                      |
|                                                      |
|    0 - Salir                                         |
 ------------------------------------------------------

3
[name: Shelley, Mary Wollstonecraft
birthYear: 1797
deathYear: 1851
]
 ------------------------------------------------------
|    1 - Buscar Libro por titulo                       |
|    2 - Listar libros registrados                     |
|    3 - Listar autores registrados                    |
|    4 - Listar autores vivos en un determinado año    |
|    5 - listar libros por idioma                      |
|                                                      |
|    0 - Salir                                         |
 ------------------------------------------------------

4
Introduce el año a consultar: 1800
[name: Shelley, Mary Wollstonecraft
birthYear: 1797
deathYear: 1851
]
 ------------------------------------------------------
|    1 - Buscar Libro por titulo                       |
|    2 - Listar libros registrados                     |
|    3 - Listar autores registrados                    |
|    4 - Listar autores vivos en un determinado año    |
|    5 - listar libros por idioma                      |
|                                                      |
|    0 - Salir                                         |
 ------------------------------------------------------

0
```

## Notas

- Asegúrate de que las variables de entorno estén correctamente configuradas antes de ejecutar la aplicación.
- La conexión a la base de datos se realiza utilizando las configuraciones especificadas en `application.properties`.
- La información sobre libros se obtiene de la API de [Gutendex](https://gutendex.com).
