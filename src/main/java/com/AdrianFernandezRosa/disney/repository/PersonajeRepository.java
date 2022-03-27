package com.AdrianFernandezRosa.disney.repository;

import com.AdrianFernandezRosa.disney.entities.Pelicula;
import com.AdrianFernandezRosa.disney.entities.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.List;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

    Boolean existsByNombre(String nombre);

    //SINGLE:

    List<Personaje> findByNombre(String nombre);

    List<Personaje> findByNombreStartingWith(String nombre);

    List<Personaje> findByEdad(Integer edad);

    List<Personaje> findByPeliculasId(Long id);

    //Double:

    List<Personaje> findByNombreStartingWithAndEdad(String nombre, Integer edad);

    List<Personaje> findByNombreStartingWithAndPeso(String nombre, Double peso);

    List<Personaje> findByEdadAndPeso(Integer edad, Double peso);

   List<Personaje> findByNombreStartingWithAndPeliculasId(String nombre, Long id);

   List<Personaje> findByPesoAndPeliculasId(Double Peso, Long Id);

    List<Personaje> findByPeliculasIn(Collection<Pelicula> peliculas);

  // three:
  List<Personaje> findByNombreStartingWithAndEdadAndPeso(String nombre, Integer edad, Double peso);















}
