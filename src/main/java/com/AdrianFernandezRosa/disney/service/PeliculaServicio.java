package com.AdrianFernandezRosa.disney.service;

import com.AdrianFernandezRosa.disney.entities.Pelicula;

import java.util.List;

public interface PeliculaServicio {



    List<Pelicula> findAll();

    List<Pelicula> findByNombreStartingWith(String name);

    Pelicula editarPelicula(Pelicula pelicula);

    List<Pelicula> findByAllParameters(String name,Long idGenero,Boolean orden);

    void deleteById(Long id);

    void agregarPelicula(Long idP, Long idPersonaje);

    void removerPelicula(Long idP, Long idPersonaje);

    void eliminarPelicula(Pelicula pelicula);




}
