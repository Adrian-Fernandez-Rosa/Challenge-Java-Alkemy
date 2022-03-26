package com.AdrianFernandezRosa.disney;

import com.AdrianFernandezRosa.disney.entities.Pelicula;
import com.AdrianFernandezRosa.disney.entities.Personaje;
import com.AdrianFernandezRosa.disney.repository.PeliculaRepository;
import com.AdrianFernandezRosa.disney.repository.PersonajeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DisneyApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DisneyApplication.class, args);


		//test fast bizarro

		ApplicationContext context = SpringApplication.run(DisneyApplication.class, args);
		PersonajeRepository pRepository = context.getBean(PersonajeRepository.class);

		PeliculaRepository peliculaRepository = context.getBean(PeliculaRepository.class);
		Pelicula peli = peliculaRepository.findById(50505050L).get();

		System.out.println("Peli id "+peli.getId());

		List<Pelicula> peliculas = new ArrayList<>();
		peliculas.add(peli);





		List<Personaje> personajes = pRepository.findByPeliculasIn(peliculas);
		System.out.println("personajes size "+ personajes.size()+ " peliculas size "+peliculas.size());

		System.out.println(personajes.get(0).getNombre());
	}

}
