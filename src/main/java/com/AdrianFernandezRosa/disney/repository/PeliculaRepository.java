package com.AdrianFernandezRosa.disney.repository;

import com.AdrianFernandezRosa.disney.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {


}
