# 📚 Desafio LiterAlura

Este es un proyecto de aplicación de consola desarrollado en Java con el framework Spring. La aplicación se conecta a una API REST externa para obtener información sobre libros y la guarda en una base de datos utilizando JPA e Hibernate para la persistencia.

## 📋 Características

- Conexión a una API REST para obtener información de libros.
- Almacena los datos obtenidos en una base de datos utilizando JPA Hibernate.
- Dos entidades principales: `Libro` y `Autor`.

## 📦 Requisitos

- **Java 17** o superior
- **Maven** para la gestión de dependencias
- **PostgreSQL** u otra base de datos compatible con JPA
- **Spring Boot**
- **JPA Hibernate**

## 🚀 Instalación

1. Clona el repositorio en tu máquina local:
    ```bash
    git clone https://github.com/AguilarDev29/DesafioONELiteralura.git
    cd DesafioONELiteralura
    ```

2. Configura las variables de entorno o el archivo `application.properties` con los datos de tu base de datos:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost/book_db
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Ejecuta la aplicación:
    ```bash
    mvn spring-boot:run
    ```

## 🛠️ Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para la creación de aplicaciones Java.
- **Spring Data JPA**: Proporciona acceso a la base de datos y mapeo objeto-relacional con Hibernate.
- **Hibernate**: ORM utilizado para la persistencia de datos.
- **API REST**: Conexión con una API externa para obtener información de libros.
- **PostgreSQL**: Base de datos utilizada para almacenar la información de libros y autores.

## 🗂️ Estructura del Proyecto

- `src/main/java`: Contiene el código fuente de la aplicación.
    - `model`: Interfaz CLI y lógica.
    - `repository`: Repositorios de acceso a la base de datos.
    - `model`: Entidades `Libro` y `Autor`.
- `src/main/resources`: Archivos de configuración de la aplicación.

## 📝 Uso de la Aplicación

La aplicación realiza una consulta a la API REST externa y almacena la información de libros en la base de datos. Puedes consultar los datos almacenados mediante métodos de acceso proporcionados por los repositorios de JPA o implementar una interfaz de usuario adicional si deseas consultar la base de datos desde una interfaz gráfica o web.

