package com.AdrianFernandezRosa.disney.repository;

import com.AdrianFernandezRosa.disney.entities.Pelicula;
import com.AdrianFernandezRosa.disney.entities.Personaje;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    @Override
    List<Pelicula> findAll();

    List<Pelicula> findByPersonajesAsociadosContains(Personaje personaje);

    Optional<Pelicula> findById(Long Id);

    Boolean existsPeliculaByTituloIgnoreCase(String titulo);

    List<Pelicula> findByTituloStartingWithOrderByFechaCreacionAsc(String name);

    List<Pelicula> findByTituloStartingWith(String name, Sort orden);

    List<Pelicula> findAll(Sort orden);

    List<Pelicula> findByGenerosId(Long id, Sort orden);



    // Pelicula findByOrderByFechaCreacionAscAndByTituloStartingWith(String name);

    Pelicula findByGenerosId(Long id);
    //    List<Personaje> findByPeliculasId(Long id);


}
