package com.devaguilar.gestorDeLibros.repository;

import com.devaguilar.gestorDeLibros.model.Idioma;
import com.devaguilar.gestorDeLibros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l")
    List<Libro> getLibros();
    List<Libro> findByIdiomas(List<Idioma> idioma);
}
