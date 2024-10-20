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
Frankenstein; Or, The Modern Prometheus
[
  {
    "id": 84,
    "title": "Frankenstein; Or, The Modern Prometheus",
    "subjects": [
      "Frankenstein\u0027s monster (Fictitious character) -- Fiction",
      "Frankenstein, Victor (Fictitious character) -- Fiction",
      "Gothic fiction",
      "Horror tales",
      "Monsters -- Fiction",
      "Science fiction",
      "Scientists -- Fiction"
    ],
    "authors": [
      {
        "birth_year": 1797,
        "death_year": 1851,
        "name": "Shelley, Mary Wollstonecraft"
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Culture/Civilization/Society",
      "Browsing: Fiction",
      "Browsing: Gender \u0026 Sexuality Studies",
      "Browsing: Literature",
      "Browsing: Science-Fiction \u0026 Fantasy",
      "Gothic Fiction",
      "Movie Books",
      "Precursors of Science Fiction",
      "Science Fiction by Women"
    ],
    "languages": [
      "en"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/84.html.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/84.epub3.images",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/84.kf8.images",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/84.rdf",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/84/pg84.cover.medium.jpg",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/84.txt.utf-8",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/84/pg84-h.zip"
    },
    "download_count": 78467
  },
  {
    "id": 41445,
    "title": "Frankenstein; Or, The Modern Prometheus",
    "subjects": [
      "Frankenstein\u0027s monster (Fictitious character) -- Fiction",
      "Frankenstein, Victor (Fictitious character) -- Fiction",
      "Gothic fiction",
      "Horror tales",
      "Monsters -- Fiction",
      "Science fiction",
      "Scientists -- Fiction"
    ],
    "authors": [
      {
        "birth_year": 1797,
        "death_year": 1851,
        "name": "Shelley, Mary Wollstonecraft"
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Gender \u0026 Sexuality Studies",
      "Browsing: Literature",
      "Browsing: Science-Fiction \u0026 Fantasy",
      "Precursors of Science Fiction",
      "Science Fiction by Women"
    ],
    "languages": [
      "en"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/41445.html.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/41445.epub3.images",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/41445.kf8.images",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/41445.rdf",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/41445/pg41445.cover.medium.jpg",
      "application/octet-stream": "https://www.gutenberg.org/files/41445/41445-0.zip",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/41445.txt.utf-8"
    },
    "download_count": 12661
  },
  {
    "id": 42324,
    "title": "Frankenstein; Or, The Modern Prometheus",
    "subjects": [
      "Frankenstein\u0027s monster (Fictitious character) -- Fiction",
      "Frankenstein, Victor (Fictitious character) -- Fiction",
      "Gothic fiction",
      "Horror tales",
      "Monsters -- Fiction",
      "Science fiction",
      "Scientists -- Fiction"
    ],
    "authors": [
      {
        "birth_year": 1797,
        "death_year": 1851,
        "name": "Shelley, Mary Wollstonecraft"
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Science-Fiction \u0026 Fantasy",
      "Precursors of Science Fiction",
      "Science Fiction by Women"
    ],
    "languages": [
      "en"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/42324.html.images",
      "text/html; charset\u003diso-8859-1": "https://www.gutenberg.org/files/42324/42324-h/42324-h.htm",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/42324.epub3.images",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/42324.kf8.images",
      "text/plain; charset\u003diso-8859-1": "https://www.gutenberg.org/files/42324/42324-8.txt",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/42324.rdf",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/42324/pg42324.cover.medium.jpg",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/42324.txt.utf-8",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/42324/pg42324-h.zip"
    },
    "download_count": 8891
  },
  {
    "id": 20038,
    "title": "Frankenstein; Or, The Modern Prometheus",
    "subjects": [
      "Frankenstein\u0027s monster (Fictitious character) -- Fiction",
      "Frankenstein, Victor (Fictitious character) -- Fiction",
      "Gothic fiction",
      "Horror tales",
      "Monsters -- Fiction",
      "Science fiction",
      "Scientists -- Fiction"
    ],
    "authors": [
      {
        "birth_year": 1797,
        "death_year": 1851,
        "name": "Shelley, Mary Wollstonecraft"
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature",
      "Browsing: Science-Fiction \u0026 Fantasy",
      "Movie Books",
      "Precursors of Science Fiction",
      "Science Fiction by Women"
    ],
    "languages": [
      "en"
    ],
    "copyright": false,
    "media_type": "Sound",
    "formats": {
      "text/plain": "https://www.gutenberg.org/files/20038/20038-readme.txt",
      "text/html": "https://www.gutenberg.org/files/20038/20038-index.html",
      "audio/ogg": "https://www.gutenberg.org/files/20038/ogg/20038-01.ogg",
      "audio/mp4": "https://www.gutenberg.org/files/20038/m4b/20038-01.m4a",
      "audio/mpeg": "https://www.gutenberg.org/files/20038/mp3/20038-01.mp3",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/20038.rdf"
    },
    "download_count": 784
  }
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

2
[
  {
    "id": 84,
    "title": "Frankenstein; Or, The Modern Prometheus",
    "subjects": [
      "Frankenstein\u0027s monster (Fictitious character) -- Fiction",
      "Frankenstein, Victor (Fictitious character) -- Fiction",
      "Gothic fiction",
      "Horror tales",
      "Monsters -- Fiction",
      "Science fiction",
      "Scientists -- Fiction"
    ],
    "authors": [
      {
        "name": "Shelley, Mary Wollstonecraft",
        "BirthYear": 1797,
        "DeathYear": 1851
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Culture/Civilization/Society",
      "Browsing: Fiction",
      "Browsing: Gender \u0026 Sexuality Studies",
      "Browsing: Literature",
      "Browsing: Science-Fiction \u0026 Fantasy",
      "Gothic Fiction",
      "Movie Books",
      "Precursors of Science Fiction",
      "Science Fiction by Women"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/84.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/84/pg84-h.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/84/pg84.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/84.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/84.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/84.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/84.txt.utf-8"
    },
    "download_count": 78467
  },
  {
    "id": 41445,
    "title": "Frankenstein; Or, The Modern Prometheus",
    "subjects": [
      "Frankenstein\u0027s monster (Fictitious character) -- Fiction",
      "Frankenstein, Victor (Fictitious character) -- Fiction",
      "Gothic fiction",
      "Horror tales",
      "Monsters -- Fiction",
      "Science fiction",
      "Scientists -- Fiction"
    ],
    "authors": [
      {
        "name": "Shelley, Mary Wollstonecraft",
        "BirthYear": 1797,
        "DeathYear": 1851
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Gender \u0026 Sexuality Studies",
      "Browsing: Literature",
      "Browsing: Science-Fiction \u0026 Fantasy",
      "Precursors of Science Fiction",
      "Science Fiction by Women"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/41445.html.images",
      "application/octet-stream": "https://www.gutenberg.org/files/41445/41445-0.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/41445/pg41445.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/41445.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/41445.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/41445.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/41445.txt.utf-8"
    },
    "download_count": 12661
  },
  {
    "id": 42324,
    "title": "Frankenstein; Or, The Modern Prometheus",
    "subjects": [
      "Frankenstein\u0027s monster (Fictitious character) -- Fiction",
      "Frankenstein, Victor (Fictitious character) -- Fiction",
      "Gothic fiction",
      "Horror tales",
      "Monsters -- Fiction",
      "Science fiction",
      "Scientists -- Fiction"
    ],
    "authors": [
      {
        "name": "Shelley, Mary Wollstonecraft",
        "BirthYear": 1797,
        "DeathYear": 1851
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Science-Fiction \u0026 Fantasy",
      "Precursors of Science Fiction",
      "Science Fiction by Women"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/plain; charset\u003diso-8859-1": "https://www.gutenberg.org/files/42324/42324-8.txt",
      "text/html": "https://www.gutenberg.org/ebooks/42324.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/42324/pg42324-h.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/42324/pg42324.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/42324.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/42324.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/42324.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/42324.txt.utf-8",
      "text/html; charset\u003diso-8859-1": "https://www.gutenberg.org/files/42324/42324-h/42324-h.htm"
    },
    "download_count": 8891
  },
  {
    "id": 20038,
    "title": "Frankenstein; Or, The Modern Prometheus",
    "subjects": [
      "Frankenstein\u0027s monster (Fictitious character) -- Fiction",
      "Frankenstein, Victor (Fictitious character) -- Fiction",
      "Gothic fiction",
      "Horror tales",
      "Monsters -- Fiction",
      "Science fiction",
      "Scientists -- Fiction"
    ],
    "authors": [
      {
        "name": "Shelley, Mary Wollstonecraft",
        "BirthYear": 1797,
        "DeathYear": 1851
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature",
      "Browsing: Science-Fiction \u0026 Fantasy",
      "Movie Books",
      "Precursors of Science Fiction",
      "Science Fiction by Women"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Sound",
    "formats": {
      "audio/ogg": "https://www.gutenberg.org/files/20038/ogg/20038-01.ogg",
      "text/html": "https://www.gutenberg.org/files/20038/20038-index.html",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/20038.rdf",
      "audio/mp4": "https://www.gutenberg.org/files/20038/m4b/20038-01.m4a",
      "text/plain": "https://www.gutenberg.org/files/20038/20038-readme.txt",
      "audio/mpeg": "https://www.gutenberg.org/files/20038/mp3/20038-01.mp3"
    },
    "download_count": 784
  },
  {
    "id": 25344,
    "title": "The Scarlet Letter",
    "subjects": [
      "Adultery -- Fiction",
      "Boston (Mass.) -- History -- Colonial period, ca. 1600-1775 -- Fiction",
      "Clergy -- Fiction",
      "Historical fiction",
      "Illegitimate children -- Fiction",
      "Married women -- Fiction",
      "Psychological fiction",
      "Puritans -- Fiction",
      "Revenge -- Fiction",
      "Triangles (Interpersonal relations) -- Fiction",
      "Women immigrants -- Fiction"
    ],
    "authors": [
      {
        "name": "Hawthorne, Nathaniel",
        "BirthYear": 1804,
        "DeathYear": 1864
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Culture/Civilization/Society",
      "Browsing: Fiction",
      "Browsing: Literature",
      "Banned Books from Anne Haight\u0027s list",
      "Browsing: History - American"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/25344.html.images",
      "application/octet-stream": "https://www.gutenberg.org/files/25344/25344-0.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/25344/pg25344.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/25344.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/25344.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/25344.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/25344.txt.utf-8"
    },
    "download_count": 45002
  },
  {
    "id": 33,
    "title": "The Scarlet Letter",
    "subjects": [
      "Adultery -- Fiction",
      "Boston (Mass.) -- History -- Colonial period, ca. 1600-1775 -- Fiction",
      "Clergy -- Fiction",
      "Historical fiction",
      "Illegitimate children -- Fiction",
      "Married women -- Fiction",
      "Psychological fiction",
      "Puritans -- Fiction",
      "Revenge -- Fiction",
      "Triangles (Interpersonal relations) -- Fiction",
      "Women immigrants -- Fiction"
    ],
    "authors": [
      {
        "name": "Hawthorne, Nathaniel",
        "BirthYear": 1804,
        "DeathYear": 1864
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Culture/Civilization/Society",
      "Browsing: Fiction",
      "Browsing: Literature",
      "Movie Books",
      "Browsing: History - American",
      "Harvard Classics"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/33.html.images",
      "application/octet-stream": "https://www.gutenberg.org/files/33/33-0.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/33/pg33.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/33.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/33.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/33.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/33.txt.utf-8"
    },
    "download_count": 1506
  },
  {
    "id": 1513,
    "title": "Romeo and Juliet",
    "subjects": [
      "Conflict of generations -- Drama",
      "Juliet (Fictitious character) -- Drama",
      "Romeo (Fictitious character) -- Drama",
      "Tragedies",
      "Vendetta -- Drama",
      "Verona (Italy) -- Drama",
      "Youth -- Drama"
    ],
    "authors": [
      {
        "name": "Shakespeare, William",
        "BirthYear": 1564,
        "DeathYear": 1616
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature",
      "Browsing: Poetry"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/1513.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/1513/pg1513-h.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/1513/pg1513.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/1513.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/1513.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/1513.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/1513.txt.utf-8"
    },
    "download_count": 62300
  },
  {
    "id": 1112,
    "title": "The Tragedy of Romeo and Juliet",
    "subjects": [
      "Conflict of generations -- Drama",
      "Juliet (Fictitious character) -- Drama",
      "Romeo (Fictitious character) -- Drama",
      "Vendetta -- Drama",
      "Verona (Italy) -- Drama",
      "Youth -- Drama"
    ],
    "authors": [
      {
        "name": "Shakespeare, William",
        "BirthYear": 1564,
        "DeathYear": 1616
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Culture/Civilization/Society",
      "Browsing: Fiction",
      "Browsing: Literature",
      "Italy"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/1112.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/1112/pg1112-h.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/1112/pg1112.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/1112.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/1112.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/1112.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/1112.txt.utf-8"
    },
    "download_count": 1057
  },
  {
    "id": 47960,
    "title": "Shakespeare\u0027s Tragedy of Romeo and Juliet",
    "subjects": [
      "Conflict of generations -- Drama",
      "Juliet (Fictitious character) -- Drama",
      "Romeo (Fictitious character) -- Drama",
      "Tragedies",
      "Vendetta -- Drama",
      "Verona (Italy) -- Drama",
      "Youth -- Drama"
    ],
    "authors": [
      {
        "name": "Shakespeare, William",
        "BirthYear": 1564,
        "DeathYear": 1616
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html; charset\u003dutf-8": "https://www.gutenberg.org/files/47960/47960-h/47960-h.htm",
      "text/html": "https://www.gutenberg.org/ebooks/47960.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/47960/pg47960-h.zip",
      "text/plain; charset\u003dutf-8": "https://www.gutenberg.org/files/47960/47960-0.txt",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/47960/pg47960.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/47960.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/47960.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/47960.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/47960.txt.utf-8"
    },
    "download_count": 243
  },
  {
    "id": 1777,
    "title": "Romeo and Juliet",
    "subjects": [
      "Conflict of generations -- Drama",
      "Juliet (Fictitious character) -- Drama",
      "Romeo (Fictitious character) -- Drama",
      "Tragedies",
      "Vendetta -- Drama",
      "Verona (Italy) -- Drama",
      "Youth -- Drama"
    ],
    "authors": [
      {
        "name": "Shakespeare, William",
        "BirthYear": 1564,
        "DeathYear": 1616
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/1777.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/1777/pg1777-h.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/1777/pg1777.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/1777.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/1777.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/1777.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/1777.txt.utf-8"
    },
    "download_count": 224
  },
  {
    "id": 26268,
    "title": "Romeo and Juliet",
    "subjects": [
      "Conflict of generations -- Drama",
      "Juliet (Fictitious character) -- Drama",
      "Romeo (Fictitious character) -- Drama",
      "Tragedies",
      "Vendetta -- Drama",
      "Verona (Italy) -- Drama",
      "Youth -- Drama"
    ],
    "authors": [
      {
        "name": "Shakespeare, William",
        "BirthYear": 1564,
        "DeathYear": 1616
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Sound",
    "formats": {
      "audio/ogg": "https://www.gutenberg.org/files/26268/ogg/26268-01.ogg",
      "text/html": "https://www.gutenberg.org/files/26268/26268-index.html",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/26268.rdf",
      "audio/mp4": "https://www.gutenberg.org/files/26268/m4b/26268-01.m4b",
      "text/plain": "https://www.gutenberg.org/files/26268/26268-readme.txt",
      "audio/mpeg": "https://www.gutenberg.org/files/26268/mp3/26268-01.mp3"
    },
    "download_count": 168
  },
  {
    "id": 2261,
    "title": "Romeo and Juliet",
    "subjects": [
      "Conflict of generations -- Drama",
      "Juliet (Fictitious character) -- Drama",
      "Romeo (Fictitious character) -- Drama",
      "Tragedies",
      "Vendetta -- Drama",
      "Verona (Italy) -- Drama",
      "Youth -- Drama"
    ],
    "authors": [
      {
        "name": "Shakespeare, William",
        "BirthYear": 1564,
        "DeathYear": 1616
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/2261.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/2261/pg2261-h.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/2261/pg2261.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/2261.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/2261.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/2261.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/2261.txt.utf-8"
    },
    "download_count": 127
  },
  {
    "id": 16389,
    "title": "The Enchanted April",
    "subjects": [
      "British -- Italy -- Fiction",
      "Domestic fiction",
      "Female friendship -- Fiction",
      "Italy -- Fiction",
      "Love stories"
    ],
    "authors": [
      {
        "name": "Von Arnim, Elizabeth",
        "BirthYear": 1866,
        "DeathYear": 1941
      }
    ],
    "translators": [],
    "bookshelves": [
      "Bestsellers, American, 1895-1923",
      "Browsing: Culture/Civilization/Society",
      "Browsing: Fiction",
      "Browsing: Literature"
    ],
    "languages": [
      "com.alura.challenge.model.Language@7443639d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/16389.html.images",
      "application/octet-stream": "https://www.gutenberg.org/files/16389/16389-0.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/16389/pg16389.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/16389.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/16389.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/16389.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/16389.txt.utf-8"
    },
    "download_count": 42584
  }
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
[
  {
    "Nombre": "Shelley, Mary Wollstonecraft",
    "BirthYear": 1797,
    "DeathYear": 1851
  },
  {
    "Nombre": "Shakespeare, William",
    "BirthYear": 1564,
    "DeathYear": 1616
  },
  {
    "Nombre": "Von Arnim, Elizabeth",
    "BirthYear": 1866,
    "DeathYear": 1941
  },
  {
    "Nombre": "Hawthorne, Nathaniel",
    "BirthYear": 1804,
    "DeathYear": 1864
  }
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
[
  {
    "Nombre": "Shelley, Mary Wollstonecraft",
    "BirthYear": 1797,
    "DeathYear": 1851
  }
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

5
Ingrese el idioma a consultar
en
[
  {
    "id": 33,
    "title": "The Scarlet Letter",
    "subjects": [
      "Adultery -- Fiction",
      "Boston (Mass.) -- History -- Colonial period, ca. 1600-1775 -- Fiction",
      "Clergy -- Fiction",
      "Historical fiction",
      "Illegitimate children -- Fiction",
      "Married women -- Fiction",
      "Psychological fiction",
      "Puritans -- Fiction",
      "Revenge -- Fiction",
      "Triangles (Interpersonal relations) -- Fiction",
      "Women immigrants -- Fiction"
    ],
    "authors": [
      {
        "name": "Hawthorne, Nathaniel",
        "BirthYear": 1804,
        "DeathYear": 1864
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Culture/Civilization/Society",
      "Browsing: Fiction",
      "Browsing: Literature",
      "Movie Books",
      "Browsing: History - American",
      "Harvard Classics"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/33.html.images",
      "application/octet-stream": "https://www.gutenberg.org/files/33/33-0.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/33/pg33.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/33.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/33.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/33.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/33.txt.utf-8"
    },
    "download_count": 1506
  },
  {
    "id": 84,
    "title": "Frankenstein; Or, The Modern Prometheus",
    "subjects": [
      "Frankenstein\u0027s monster (Fictitious character) -- Fiction",
      "Frankenstein, Victor (Fictitious character) -- Fiction",
      "Gothic fiction",
      "Horror tales",
      "Monsters -- Fiction",
      "Science fiction",
      "Scientists -- Fiction"
    ],
    "authors": [
      {
        "name": "Shelley, Mary Wollstonecraft",
        "BirthYear": 1797,
        "DeathYear": 1851
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Culture/Civilization/Society",
      "Browsing: Fiction",
      "Browsing: Gender \u0026 Sexuality Studies",
      "Browsing: Literature",
      "Browsing: Science-Fiction \u0026 Fantasy",
      "Gothic Fiction",
      "Movie Books",
      "Precursors of Science Fiction",
      "Science Fiction by Women"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/84.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/84/pg84-h.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/84/pg84.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/84.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/84.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/84.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/84.txt.utf-8"
    },
    "download_count": 78467
  },
  {
    "id": 1112,
    "title": "The Tragedy of Romeo and Juliet",
    "subjects": [
      "Conflict of generations -- Drama",
      "Juliet (Fictitious character) -- Drama",
      "Romeo (Fictitious character) -- Drama",
      "Vendetta -- Drama",
      "Verona (Italy) -- Drama",
      "Youth -- Drama"
    ],
    "authors": [
      {
        "name": "Shakespeare, William",
        "BirthYear": 1564,
        "DeathYear": 1616
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Culture/Civilization/Society",
      "Browsing: Fiction",
      "Browsing: Literature",
      "Italy"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/1112.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/1112/pg1112-h.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/1112/pg1112.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/1112.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/1112.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/1112.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/1112.txt.utf-8"
    },
    "download_count": 1057
  },
  {
    "id": 1513,
    "title": "Romeo and Juliet",
    "subjects": [
      "Conflict of generations -- Drama",
      "Juliet (Fictitious character) -- Drama",
      "Romeo (Fictitious character) -- Drama",
      "Tragedies",
      "Vendetta -- Drama",
      "Verona (Italy) -- Drama",
      "Youth -- Drama"
    ],
    "authors": [
      {
        "name": "Shakespeare, William",
        "BirthYear": 1564,
        "DeathYear": 1616
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature",
      "Browsing: Poetry"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/1513.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/1513/pg1513-h.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/1513/pg1513.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/1513.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/1513.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/1513.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/1513.txt.utf-8"
    },
    "download_count": 62300
  },
  {
    "id": 1777,
    "title": "Romeo and Juliet",
    "subjects": [
      "Conflict of generations -- Drama",
      "Juliet (Fictitious character) -- Drama",
      "Romeo (Fictitious character) -- Drama",
      "Tragedies",
      "Vendetta -- Drama",
      "Verona (Italy) -- Drama",
      "Youth -- Drama"
    ],
    "authors": [
      {
        "name": "Shakespeare, William",
        "BirthYear": 1564,
        "DeathYear": 1616
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/1777.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/1777/pg1777-h.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/1777/pg1777.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/1777.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/1777.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/1777.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/1777.txt.utf-8"
    },
    "download_count": 224
  },
  {
    "id": 2261,
    "title": "Romeo and Juliet",
    "subjects": [
      "Conflict of generations -- Drama",
      "Juliet (Fictitious character) -- Drama",
      "Romeo (Fictitious character) -- Drama",
      "Tragedies",
      "Vendetta -- Drama",
      "Verona (Italy) -- Drama",
      "Youth -- Drama"
    ],
    "authors": [
      {
        "name": "Shakespeare, William",
        "BirthYear": 1564,
        "DeathYear": 1616
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/2261.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/2261/pg2261-h.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/2261/pg2261.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/2261.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/2261.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/2261.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/2261.txt.utf-8"
    },
    "download_count": 127
  },
  {
    "id": 16389,
    "title": "The Enchanted April",
    "subjects": [
      "British -- Italy -- Fiction",
      "Domestic fiction",
      "Female friendship -- Fiction",
      "Italy -- Fiction",
      "Love stories"
    ],
    "authors": [
      {
        "name": "Von Arnim, Elizabeth",
        "BirthYear": 1866,
        "DeathYear": 1941
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Culture/Civilization/Society",
      "Browsing: Fiction",
      "Browsing: Literature",
      "Bestsellers, American, 1895-1923"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/16389.html.images",
      "application/octet-stream": "https://www.gutenberg.org/files/16389/16389-0.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/16389/pg16389.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/16389.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/16389.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/16389.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/16389.txt.utf-8"
    },
    "download_count": 42584
  },
  {
    "id": 20038,
    "title": "Frankenstein; Or, The Modern Prometheus",
    "subjects": [
      "Frankenstein\u0027s monster (Fictitious character) -- Fiction",
      "Frankenstein, Victor (Fictitious character) -- Fiction",
      "Gothic fiction",
      "Horror tales",
      "Monsters -- Fiction",
      "Science fiction",
      "Scientists -- Fiction"
    ],
    "authors": [
      {
        "name": "Shelley, Mary Wollstonecraft",
        "BirthYear": 1797,
        "DeathYear": 1851
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature",
      "Browsing: Science-Fiction \u0026 Fantasy",
      "Movie Books",
      "Precursors of Science Fiction",
      "Science Fiction by Women"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Sound",
    "formats": {
      "audio/ogg": "https://www.gutenberg.org/files/20038/ogg/20038-01.ogg",
      "text/html": "https://www.gutenberg.org/files/20038/20038-index.html",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/20038.rdf",
      "audio/mp4": "https://www.gutenberg.org/files/20038/m4b/20038-01.m4a",
      "text/plain": "https://www.gutenberg.org/files/20038/20038-readme.txt",
      "audio/mpeg": "https://www.gutenberg.org/files/20038/mp3/20038-01.mp3"
    },
    "download_count": 784
  },
  {
    "id": 25344,
    "title": "The Scarlet Letter",
    "subjects": [
      "Adultery -- Fiction",
      "Boston (Mass.) -- History -- Colonial period, ca. 1600-1775 -- Fiction",
      "Clergy -- Fiction",
      "Historical fiction",
      "Illegitimate children -- Fiction",
      "Married women -- Fiction",
      "Psychological fiction",
      "Puritans -- Fiction",
      "Revenge -- Fiction",
      "Triangles (Interpersonal relations) -- Fiction",
      "Women immigrants -- Fiction"
    ],
    "authors": [
      {
        "name": "Hawthorne, Nathaniel",
        "BirthYear": 1804,
        "DeathYear": 1864
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Culture/Civilization/Society",
      "Browsing: Fiction",
      "Browsing: Literature",
      "Banned Books from Anne Haight\u0027s list",
      "Browsing: History - American"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/25344.html.images",
      "application/octet-stream": "https://www.gutenberg.org/files/25344/25344-0.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/25344/pg25344.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/25344.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/25344.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/25344.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/25344.txt.utf-8"
    },
    "download_count": 45002
  },
  {
    "id": 26268,
    "title": "Romeo and Juliet",
    "subjects": [
      "Conflict of generations -- Drama",
      "Juliet (Fictitious character) -- Drama",
      "Romeo (Fictitious character) -- Drama",
      "Tragedies",
      "Vendetta -- Drama",
      "Verona (Italy) -- Drama",
      "Youth -- Drama"
    ],
    "authors": [
      {
        "name": "Shakespeare, William",
        "BirthYear": 1564,
        "DeathYear": 1616
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Sound",
    "formats": {
      "audio/ogg": "https://www.gutenberg.org/files/26268/ogg/26268-01.ogg",
      "text/html": "https://www.gutenberg.org/files/26268/26268-index.html",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/26268.rdf",
      "audio/mp4": "https://www.gutenberg.org/files/26268/m4b/26268-01.m4b",
      "text/plain": "https://www.gutenberg.org/files/26268/26268-readme.txt",
      "audio/mpeg": "https://www.gutenberg.org/files/26268/mp3/26268-01.mp3"
    },
    "download_count": 168
  },
  {
    "id": 41445,
    "title": "Frankenstein; Or, The Modern Prometheus",
    "subjects": [
      "Frankenstein\u0027s monster (Fictitious character) -- Fiction",
      "Frankenstein, Victor (Fictitious character) -- Fiction",
      "Gothic fiction",
      "Horror tales",
      "Monsters -- Fiction",
      "Science fiction",
      "Scientists -- Fiction"
    ],
    "authors": [
      {
        "name": "Shelley, Mary Wollstonecraft",
        "BirthYear": 1797,
        "DeathYear": 1851
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Gender \u0026 Sexuality Studies",
      "Browsing: Literature",
      "Browsing: Science-Fiction \u0026 Fantasy",
      "Precursors of Science Fiction",
      "Science Fiction by Women"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html": "https://www.gutenberg.org/ebooks/41445.html.images",
      "application/octet-stream": "https://www.gutenberg.org/files/41445/41445-0.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/41445/pg41445.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/41445.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/41445.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/41445.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/41445.txt.utf-8"
    },
    "download_count": 12661
  },
  {
    "id": 42324,
    "title": "Frankenstein; Or, The Modern Prometheus",
    "subjects": [
      "Frankenstein\u0027s monster (Fictitious character) -- Fiction",
      "Frankenstein, Victor (Fictitious character) -- Fiction",
      "Gothic fiction",
      "Horror tales",
      "Monsters -- Fiction",
      "Science fiction",
      "Scientists -- Fiction"
    ],
    "authors": [
      {
        "name": "Shelley, Mary Wollstonecraft",
        "BirthYear": 1797,
        "DeathYear": 1851
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Science-Fiction \u0026 Fantasy",
      "Precursors of Science Fiction",
      "Science Fiction by Women"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/plain; charset\u003diso-8859-1": "https://www.gutenberg.org/files/42324/42324-8.txt",
      "text/html": "https://www.gutenberg.org/ebooks/42324.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/42324/pg42324-h.zip",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/42324/pg42324.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/42324.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/42324.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/42324.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/42324.txt.utf-8",
      "text/html; charset\u003diso-8859-1": "https://www.gutenberg.org/files/42324/42324-h/42324-h.htm"
    },
    "download_count": 8891
  },
  {
    "id": 47960,
    "title": "Shakespeare\u0027s Tragedy of Romeo and Juliet",
    "subjects": [
      "Conflict of generations -- Drama",
      "Juliet (Fictitious character) -- Drama",
      "Romeo (Fictitious character) -- Drama",
      "Tragedies",
      "Vendetta -- Drama",
      "Verona (Italy) -- Drama",
      "Youth -- Drama"
    ],
    "authors": [
      {
        "name": "Shakespeare, William",
        "BirthYear": 1564,
        "DeathYear": 1616
      }
    ],
    "translators": [],
    "bookshelves": [
      "Browsing: Fiction",
      "Browsing: Literature"
    ],
    "languages": [
      "com.alura.challenge.model.Language@6f0d6a1d"
    ],
    "copyright": false,
    "media_type": "Text",
    "formats": {
      "text/html; charset\u003dutf-8": "https://www.gutenberg.org/files/47960/47960-h/47960-h.htm",
      "text/html": "https://www.gutenberg.org/ebooks/47960.html.images",
      "application/octet-stream": "https://www.gutenberg.org/cache/epub/47960/pg47960-h.zip",
      "text/plain; charset\u003dutf-8": "https://www.gutenberg.org/files/47960/47960-0.txt",
      "image/jpeg": "https://www.gutenberg.org/cache/epub/47960/pg47960.cover.medium.jpg",
      "application/rdf+xml": "https://www.gutenberg.org/ebooks/47960.rdf",
      "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/47960.kf8.images",
      "application/epub+zip": "https://www.gutenberg.org/ebooks/47960.epub3.images",
      "text/plain; charset\u003dus-ascii": "https://www.gutenberg.org/ebooks/47960.txt.utf-8"
    },
    "download_count": 243
  }
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
Cerrando la aplicación...
```

## Notas

- Asegúrate de que las variables de entorno estén correctamente configuradas antes de ejecutar la aplicación.
- La conexión a la base de datos se realiza utilizando las configuraciones especificadas en `application.properties`.
- La información sobre libros se obtiene de la API de [Gutendex](https://gutendex.com).
