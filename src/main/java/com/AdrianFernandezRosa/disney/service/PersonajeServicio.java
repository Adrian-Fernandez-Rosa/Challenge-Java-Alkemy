package com.AdrianFernandezRosa.disney.service;

import com.AdrianFernandezRosa.disney.dto.PersonajeAux;
import com.AdrianFernandezRosa.disney.entities.Personaje;

import java.util.List;
import java.util.Optional;

public interface PersonajeServicio {

    List<Personaje> findAll();

    List<Personaje> findByNombreStartingWith(String name);

    List<Personaje> findByEdad(Integer age);

    List<PersonajeAux> findByAllParameters(String name, Integer age, Long idMovie);

    void save(Personaje personaje) throws Exception;

    List<Personaje> findByPeliculasId(Long movie);

    Personaje modificarPersonaje(Personaje personaje) throws Exception;

    Boolean deleteById(Long id);



}
