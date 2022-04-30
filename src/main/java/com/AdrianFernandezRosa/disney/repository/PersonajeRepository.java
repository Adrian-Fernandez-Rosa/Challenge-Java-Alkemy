package com.AdrianFernandezRosa.disney.repository;

import com.AdrianFernandezRosa.disney.entities.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {


    List<Personaje> findByNombreStartingWith(String name);

    List<Personaje> findByEdad(Integer age);

    Boolean existsPersonajeByNombreIgnoreCase(String nombre);

    List<Personaje> findByPeliculasId(Long id);

    void deleteById(Long id);



}
