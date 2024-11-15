package com.devaguilar.gestorDeLibros.repository;

import com.devaguilar.gestorDeLibros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AutorRepository extends JpaRepository<Autor, String> {
    Optional<Autor> findByNombre(String nombre);
    @Query("SELECT a FROM Autor a JOIN a.libros l")
    List<Autor> getAutores();
    @Query("SELECT a FROM Autor a WHERE :anio BETWEEN a.anioNacimiento AND a.anioDefuncion")
    List<Autor> getAutoresVivos(Integer anio);
}
