package com.AdrianFernandezRosa.disney.service;


import com.AdrianFernandezRosa.disney.dto.PersonajeAux;
import com.AdrianFernandezRosa.disney.entities.Personaje;
import com.AdrianFernandezRosa.disney.repository.PersonajeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PersonajeServicioImpl implements PersonajeServicio {

    private final Logger log = LoggerFactory.getLogger(PersonajeServicioImpl.class);

    private PersonajeRepository pRepository;

    public PersonajeServicioImpl(PersonajeRepository personajeRepository) {
        this.pRepository = personajeRepository;
    }

    @Override
    public List<Personaje> findAll() {
        return pRepository.findAll();
    }

    @Override
    public List<Personaje> findByNombreStartingWith(String name) {
        return pRepository.findByNombreStartingWith(name.trim());
    }

    @Override
    public List<Personaje> findByEdad(Integer age) {

        return pRepository.findByEdad(age);
    }



    @Override //refactorizar usando solid
    public List<PersonajeAux> findByAllParameters(String name, Integer age, Long idMovie) {

        List<Personaje> personajes = new ArrayList<>();
        if (name == null && age == null && idMovie == null){
            personajes = findAll();
            return mapper(personajes);
        }

        if (!(name == null)){
            personajes = pRepository.findByNombreStartingWith(name);
        }
        if (!(age== null)){

            if(!personajes.isEmpty()){

                Predicate<Personaje> filter = personaje -> Objects.equals(personaje.getEdad(), age);

                personajes = personajes.stream().filter(filter).collect(Collectors.toList());

            } else {
                personajes = pRepository.findByEdad(age);
            }
        }

        if (!(idMovie == null)){

            if (!personajes.isEmpty()){

                Predicate<Personaje> filter = personaje -> {
                    return personaje.getPeliculas().stream().anyMatch(p -> p.getId().equals(idMovie));
                };

                personajes = personajes.stream().filter(filter).collect(Collectors.toList());


            }else {
                personajes = pRepository.findByPeliculasId(idMovie);
            }
        }
        return mapper(personajes);

    }

    public List<PersonajeAux> mapper(List<Personaje> personajes){
        List<PersonajeAux> pAux = new ArrayList<>();


        for (Personaje personaje : personajes) {
            PersonajeAux p = new PersonajeAux();
            p.setNombre(personaje.getNombre());
            p.setImagen(personaje.getImagen());
            pAux.add(p);
        }
        return pAux;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class})
    public void save(Personaje personaje) throws Exception {

     //   System.out.println(personajeRepository.existsPersonajeByNombreIgnoreCase("bAtmAn"));
        validarSave(personaje);

       pRepository.save(personaje);
    }

    public void validarSave(Personaje personaje) throws Exception {

        if (personaje.getId()!=null || pRepository.existsPersonajeByNombreIgnoreCase(personaje.getNombre()) ){
            log.warn("Este personaje ya existe");
            throw new Exception("Ya existe este personaje");
        }

    }

    public void validarUpdate(Personaje personaje) throws Exception {

        if (personaje.getId() == null){
            log.warn("Esta intentando actualizar un personaje existente sin ID");
            throw new Exception("Esta intentando actualizar un personaje existente sin ID");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class})
    public void modificarPersonaje(Personaje personaje) throws Exception{

         Personaje pAux = pRepository.getById(personaje.getId());
         if (pAux == null){
             throw new NoSuchElementException("El personaje no fue encontrado");
         }


        try {
             pRepository.save(personaje);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Personaje> findByPeliculasId(Long movie) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }
}
