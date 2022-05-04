package com.AdrianFernandezRosa.disney.service;

import com.AdrianFernandezRosa.disney.dto.PeliculaDto;
import com.AdrianFernandezRosa.disney.entities.Pelicula;

import java.util.List;

public interface PeliculaServicio {



    List<Pelicula> findAll();

    List<Pelicula> findByNombreStartingWith(String name);

    Pelicula findById(Long id);

    Pelicula guardarPelicula(Pelicula pelicula) throws Exception;

    Pelicula editarPelicula(Pelicula pelicula);

    List<PeliculaDto> findByAllParameters(String name, Long idGenero, String orden) throws Exception;

    void deleteById(Long id);

    void agregarPersonaje(Long idP, Long idPersonaje);

    void removerPersonaje(Long idP, Long idPersonaje);

    void eliminarPelicula(Pelicula pelicula);




}
