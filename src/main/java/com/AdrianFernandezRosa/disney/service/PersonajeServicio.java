package com.AdrianFernandezRosa.disney.service;

import com.AdrianFernandezRosa.disney.entities.Personaje;

import java.util.List;
import java.util.Optional;

public interface PersonajeServicio {

    List<Personaje> findAll();

    Optional<Personaje> findByNombre(String name);

    List<Personaje> findByEdad(Integer edad);

    Personaje save(Personaje personaje);





}
