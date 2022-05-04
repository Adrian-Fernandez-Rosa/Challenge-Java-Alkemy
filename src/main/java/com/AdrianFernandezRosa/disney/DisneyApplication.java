package com.AdrianFernandezRosa.disney;

import com.AdrianFernandezRosa.disney.entities.Imagen;
import com.AdrianFernandezRosa.disney.entities.Pelicula;
import com.AdrianFernandezRosa.disney.entities.Personaje;
import com.AdrianFernandezRosa.disney.repository.PeliculaRepository;
import com.AdrianFernandezRosa.disney.repository.PersonajeRepository;
import com.AdrianFernandezRosa.disney.service.PersonajeServicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DisneyApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DisneyApplication.class, args);


		//test fast bizarro


		ApplicationContext context = SpringApplication.run(DisneyApplication.class, args);

		// PeliculaRepository repository = context.getBean(PeliculaRepository.class);

		// System.out.println(repository.existsPeliculaByTituloIgnoreCase("batman CONTRAATACA"));
/*
		try {

		//	List<Pelicula> pelis = repository.findByGenerosId(50010L, Sort.by(Sort.Direction.DESC, "FechaCreacion"));

			List<Pelicula> pelis = repository.findByGenerosId(50010L,null);

			pelis.forEach(pelicula -> System.out.println(pelicula.getTitulo() + " " + pelicula.getFechaCreacion()));
		} catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();

		}*/

	/*	PersonajeServicio personajeServicio = context.getBean(PersonajeServicio.class);

		try {

			Personaje p1 = new Personaje(50002L, new Imagen("vamo.jpg"),"superboooo", 32,65D,"superpositivo"
			,null);
			personajeServicio.save(p1);

		}catch (Exception e){
			e.printStackTrace();
		}*/

		/*PersonajeRepository pRepository = context.getBean(PersonajeRepository.class);

		List<Personaje> personajes = new ArrayList<>();

		String name = null;
		Integer age = null;
		Long movie = 50505052L; //50505052

		if (name == null && age == null && movie == null){
			personajes = pRepository.findAll();
		}
		if (!(name == null)){
			personajes = pRepository.findByNombreStartingWith(name);
		}
		if (!(age == null)){
			List<Personaje> auxiliarAge;

			if (!personajes.isEmpty()){

				Predicate<Personaje> filter = personaje -> Objects.equals(personaje.getEdad(), age);

				System.out.println(personajes.size());

				personajes = personajes.stream().filter(filter).collect(Collectors.toList());

				System.out.println(personajes.size());

			} else {
				personajes = pRepository.findByEdad(age);
				//personajes = Stream.concat(personajes.stream(), auxiliarAge.stream() ).collect(Collectors.toList());
			}

		}
		if (!(movie == null)){

			if (personajes.isEmpty()){

				personajes = pRepository.findByPeliculasId(movie);
			}else {

				Predicate<Personaje> filter = personaje -> {

					return personaje.getPeliculas().stream().anyMatch(p -> p.getId().equals(movie));
				};

				System.out.println("estamos en movie:");
				System.out.println(personajes.size());
				personajes = personajes.stream().filter(filter).collect(Collectors.toList());
				System.out.println(personajes.size());


			}


		}


		personajes.forEach(e -> System.out.println(e.getNombre()+ " "+ e.getEdad()));

		 personajes.get(0).getPeliculas().forEach(e -> System.out.println(e.getTitulo()));

		 */

		/*
		//test básico ver si agrega a arraylist

		 */



		/*
		PersonajeRepository pRepository = context.getBean(PersonajeRepository.class);

		PersonajeDao pDao = context.getBean(PersonajeDao.class);
		List<Personaje> personajes = pDao.findAllFilter("superman",23);

		System.out.println(personajes.get(0).getNombre());
*/



/*
		PeliculaRepository peliculaRepository = context.getBean(PeliculaRepository.class);
		Pelicula peli = peliculaRepository.findById(50505050L).get();

		System.out.println("Peli id "+peli.getId());

		List<Pelicula> peliculas = new ArrayList<>();
		peliculas.add(peli);





		List<Personaje> personajes = pRepository.findByPeliculasIn(peliculas);
		System.out.println("personajes size "+ personajes.size()+ " peliculas size "+peliculas.size());

		System.out.println(personajes.get(0).getNombre());

		List<Personaje> personajes2 = pRepository.findByPeliculasId(50505050L);

		 System.out.println(personajes2.size());

		System.out.println(personajes2.get(0).getHistoria());

		//prueba

		//List<Personaje> searchAllFiltros = pRepository.findByNombreStartingWithAndEdadAndPeso("super",23,90D);

	//	System.out.println(searchAllFiltros.size());

		//prueba starting

		List<Personaje> personaje = pRepository.findByNombreStartingWith("super");

		System.out.println(personaje.get(0).getNombre());

		// prueba starting dual
		System.out.println("---------------------------------------------");

		List<Personaje> personajesdual = pRepository.findByNombreStartingWithAndPeliculasId("super",50505050L);

		System.out.println(personajesdual.get(0).getImagen().getUrlI());

		System.out.println("---------------------------------------------");
		System.out.println("Prueba isnotnull");
	//	List<Personaje> nombrenotnull = pRepository.findByNombreStartingWithAndEdadIsNotNullAndPeso("",null, 90D);

	//	System.out.println(nombrenotnull.size());


 */
	}

}
