package com.devaguilar.gestorDeLibros.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record Datos(Integer count, @SerializedName("results") List<DatosLibro> resultado) {
}
