package com.devaguilar.gestorDeLibros.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    private String nombre;
    private Integer anioNacimiento;
    private Integer anioDefuncion;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(){}

    public Autor(String nombre, Integer anioNacimiento, Integer anioDefuncion /*Libro libro*/) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
        this.anioDefuncion = anioDefuncion;
        //this.libros.add(libro);
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Integer getAnioDefuncion() {
        return anioDefuncion;
    }

    public void setAnioDefuncion(Integer anioDefuncion) {
        this.anioDefuncion = anioDefuncion;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
