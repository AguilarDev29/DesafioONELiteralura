package com.devaguilar.gestorDeLibros.model;

import jakarta.persistence.*;
import java.util.Collections;
import java.util.List;
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne(fetch = FetchType.EAGER)
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private List<Idioma> idiomas;
    private Long numeroDescargas;

    public Libro(){}

    public Libro(Long numeroDescargas, List<Idioma> idiomas, Autor autor, String titulo) {
        this.numeroDescargas = numeroDescargas;
        this.idiomas = idiomas;
        this.autor = autor;
        this.titulo = titulo;
    }

    public Libro(DatosLibro resultadoLibro) {
        this.titulo = resultadoLibro.titulo();
        this.idiomas = Collections.singletonList(Idioma.getIdioma(resultadoLibro.idiomas().toString().substring(1, 3).toUpperCase()));
        this.numeroDescargas = resultadoLibro.numeroDescargas();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public Long getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Long numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }
}
