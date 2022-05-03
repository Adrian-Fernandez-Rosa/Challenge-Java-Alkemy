package com.AdrianFernandezRosa.disney.service;

import com.AdrianFernandezRosa.disney.dto.PersonajeAux;
import com.AdrianFernandezRosa.disney.entities.Personaje;

import java.util.List;

public interface PersonajeServicio {

    List<Personaje> findAll();

    List<Personaje> findByNombreStartingWith(String name);

    List<Personaje> findByEdad(Integer age);

    List<PersonajeAux> findByAllParameters(String name, Integer age, Long idMovie);

    Personaje  findById(Long id);

    Personaje save(Personaje personaje) throws Exception;

    List<Personaje> findByPeliculasId(Long movie);

    Personaje editarPersonaje(Personaje personaje) throws Exception;

   void deleteById(Long id) throws Exception;



}
