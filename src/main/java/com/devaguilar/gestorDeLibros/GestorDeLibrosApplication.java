package com.devaguilar.gestorDeLibros;

import com.devaguilar.gestorDeLibros.repository.AutorRepository;
import com.devaguilar.gestorDeLibros.repository.LibroRepository;
import com.devaguilar.gestorDeLibros.view.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.devaguilar.gestorDeLibros")
public class GestorDeLibrosApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private AutorRepository autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(GestorDeLibrosApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroRepository, autorRepository);
		principal.menu();
	}
}
