package com.devaguilar.gestorDeLibros.model;

import com.google.gson.annotations.SerializedName;

public record DatosAutor(
        @SerializedName("name")
        String nombre,
        @SerializedName("birth_year")
        Integer anioNacimiento,
        @SerializedName("death_year")
        Integer anioDefuncion)
{
}
