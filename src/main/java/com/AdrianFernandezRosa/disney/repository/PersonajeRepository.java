package com.AdrianFernandezRosa.disney.repository;

import com.AdrianFernandezRosa.disney.entities.Pelicula;
import com.AdrianFernandezRosa.disney.entities.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.List;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

    Boolean existsByNombre(String nombre);

    List<Personaje> findByPeliculasIn(Collection<Pelicula> peliculas);

  List<Personaje> findByNombreAndEdadAndPeso(String nombre, Integer edad, Double peso);

   List<Personaje> findByNombreAndEdad(String nombre, Integer edad);



}
