package com.devaguilar.gestorDeLibros.view;

import com.devaguilar.gestorDeLibros.model.*;
import com.devaguilar.gestorDeLibros.repository.AutorRepository;
import com.devaguilar.gestorDeLibros.repository.LibroRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private Gson gson = new Gson();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;
    private String opc;
    @Autowired
    public Principal(LibroRepository libroRepository, AutorRepository autorRepository){
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void menu(){
        System.out.println("""
              ************* Menu Principal *******************
                     
                1. Buscar libro por titulo
                2. Listar libros registrados
                3. Listar autores registrados
                4. Listar autores vivos en un determinado año
                5. Listar libros por idioma
                
                0. Salir
 
                """);
            System.out.print("Ingrese una opción: ");
            opc = sc.nextLine();
        switch (opc) {
            case "1":
                System.out.print("Ingrese el nombre del libro que desea buscar: ");
                String nombreLibro = sc.nextLine();
                Datos datos = gson.fromJson(ConsumoAPI.obtenerDatos(nombreLibro), Datos.class);
                Optional<DatosLibro> resultado = datos.resultado()
                        .stream()
                        .findFirst();
                if (resultado.isPresent()) {
                    DatosLibro resultadoLibro = resultado.get();
                    System.out.println("**************Libro Encontrado**************");
                    System.out.println("\nTitulo: " + resultadoLibro.titulo() +
                            "\nAutor: " + resultadoLibro.autor().get(0).nombre() +
                            "\nIdioma: " + resultadoLibro.idiomas().toString().substring(1, 3) +
                            "\nNumero de descargas: " + resultadoLibro.numeroDescargas());
                    System.out.println("\n********************************************\n");
                    Libro libro = new Libro(resultadoLibro);
                    DatosAutor datosAutor = resultadoLibro.autor().get(0);
                    Autor autor = new Autor(datosAutor.nombre(), datosAutor.anioNacimiento(), datosAutor.anioDefuncion());
                    Optional<Autor> autorExistente = autorRepository.findByNombre(autor.getNombre());

                    if (autorExistente.isPresent()) libro.setAutor(autorExistente.get());
                    else {
                        autorRepository.save(autor);
                        libro.setAutor(autor);
                    }
                    try{
                    libroRepository.save(libro);

                    }catch (DataIntegrityViolationException e){
                        System.out.println("Libro ya existente en la base de datos");
                    }
                } else {
                    System.out.println("Libro no encontrado");
                }
                menu();
                break;
            case "2":
                List<Libro> libros = libroRepository.getLibros();
                if (!libros.isEmpty()){
                    System.out.println("**************Libros**************");
                    libros.stream()
                            .forEach(l -> System.out.printf("Titulo: %s\nAutor: %s\nIdioma: %s\n**********************************\n",
                                    l.getTitulo(), l.getAutor().getNombre(), l.getIdiomas()));
                }
                else System.out.println("Sin resultados");
                menu();
                break;
            case "3":
                List<Autor> autores = autorRepository.getAutores();
                if (!autores.isEmpty()){
                    System.out.println("**************Autores**************");
                    autores.stream()
                            .forEach(a -> System.out.println("\nNombre: "+ a.getNombre()
                                            + "\nAño de nacimiento: " + a.getAnioNacimiento()
                                            + "\nAño de defunción: " + a.getAnioDefuncion()
                                            + "\nLibros: " + a.getLibros().stream()
                                                .map(Libro::getTitulo)
                                                .collect(Collectors.joining(", "))));
                    System.out.println("\n***********************************\n");
                }
                else System.out.println("Sin resultados");
                menu();
                break;
            case "4":
                System.out.print("Ingrese el año que quieres consultar: ");
                int anio = sc.nextInt();
                List<Autor> autoresVivos = autorRepository.getAutoresVivos(anio);
                if (!autoresVivos.isEmpty()) {
                    System.out.println("**************Autores**************");
                    autoresVivos.stream()
                            .forEach(a -> System.out.printf("\n\nNombre: %s\n\n",
                                    a.getNombre()));
                    System.out.println("***********************************");
                } else System.out.println("Sin resultados");
                menu();
                break;
            case "5":
                System.out.println("""
                            ES = Español
                            EN = Inglés
                            FR = Francés
                            PR = Portugues
                            DE = Alemán
                        """);
                System.out.print("Ingrese el idioma con el que quiere filtrar: ");
                String idioma = sc.nextLine().toUpperCase();
                List<Libro> librosFiltrados = libroRepository.findByIdiomas(Collections.singletonList(Idioma.valueOf(idioma)));
                if (!librosFiltrados.isEmpty()) {
                    System.out.println("**************Libros**************\n");
                    librosFiltrados.stream().forEach(l -> System.out.println(l.getTitulo()));
                    System.out.println("\n**********************************");
            } else System.out.println("Sin resultados");
                menu();
                break;
            case "0":
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción inválida");
                menu();
                break;
        }
    }
}
