package com.AdrianFernandezRosa.disney.repository;

import com.AdrianFernandezRosa.disney.entities.Pelicula;
import com.AdrianFernandezRosa.disney.entities.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    @Override
    List<Pelicula> findAll();

    List<Pelicula> findByPersonajesAsociadosContains(Personaje personaje);

    Optional<Pelicula> findById(Long Id);
}
