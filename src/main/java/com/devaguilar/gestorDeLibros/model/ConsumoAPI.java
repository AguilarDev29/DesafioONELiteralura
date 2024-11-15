package com.devaguilar.gestorDeLibros.model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public static String obtenerDatos(String nombre){
        try{
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS) // Habilitar redirección
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://gutendex.com/books?search=" + nombre.replace(" ", "+").toLowerCase()))
                .header("User-Agent", "Java HttpClient Bot")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
        }catch (IOException | InterruptedException e){
            return "Libro no encontrado";
        }
    }
}
