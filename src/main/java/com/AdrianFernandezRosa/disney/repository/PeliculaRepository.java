package com.AdrianFernandezRosa.disney.repository;

import com.AdrianFernandezRosa.disney.entities.Pelicula;
import com.AdrianFernandezRosa.disney.entities.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    @Override
    List<Pelicula> findAll();

    List<Pelicula> findByPersonajesAsociadosContains(Personaje personaje);

    Optional<Pelicula> findById(Long Id);

    Pelicula findByTituloStartingWithOrderByFechaCreacionAsc(String name);


    // Pelicula findByOrderByFechaCreacionAscAndByTituloStartingWith(String name);

    Pelicula findByGenerosId(Long id);
    //    List<Personaje> findByPeliculasId(Long id);


}
