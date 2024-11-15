package com.devaguilar.gestorDeLibros.model;

public enum Idioma {
    ES("es"),
    EN("en"),
    FR("fr"),
    PR("pr"),
    DE("de");

    private String minuscula;

    Idioma(String minuscula) {
        this.minuscula = minuscula;
    }

    public static Idioma getIdioma(String text){
        for(Idioma idioma : Idioma.values()){
            if(idioma.minuscula.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("No se encontró el idioma: " + text);
    }
}
