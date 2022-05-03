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
import java.util.*;
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


    @Override
    @Transactional(readOnly = true)
    public Personaje findById(Long id) {
        Optional<Personaje> personaje = pRepository.findById(id);

        if (personaje.isPresent()){
            return personaje.get();
        }else {
            throw new NoSuchElementException("No se encontro el personaje");

        }
    }

    @Override //refactorizar aplicando solid
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
    public Personaje save(Personaje personaje) throws Exception {

     //   System.out.println(personajeRepository.existsPersonajeByNombreIgnoreCase("bAtmAn"));

        validarSave(personaje);

     return  pRepository.save(personaje);
    }

    public void validarSave(Personaje personaje) throws Exception {

        if(personaje.getNombre() == null){
            throw new Exception("El nombre no puede ser nulo");
        }

        if ( pRepository.existsPersonajeByNombreIgnoreCase(personaje.getNombre()) ){
            log.warn("Este personaje ya existe");
            throw new Exception("Ya existe un personaje con este nombre");
        }

        if(personaje.getEdad() == null){
            throw new Exception("La edad no puede ser nula");
        }

        if(personaje.getPeso() == null){
            throw new Exception("El peso no puede ser nulo");
        }

        if(personaje.getHistoria() == null){
            throw new Exception("La historia no puede ser nula");
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
    public Personaje editarPersonaje(Personaje personaje) throws Exception{

        if (personaje.getId() == null){
            throw new NoSuchElementException("ERROR id no encontrado!!");
        }
         Personaje pBD = pRepository.getById(personaje.getId());
         if (pBD == null){
             throw new NoSuchElementException("El personaje no fue encontrado");
         }
        com.AdrianFernandezRosa.disney.util.personajeUtils.clonar(pBD,personaje);

        try {
             pRepository.save(pBD);
             return pBD;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Personaje> findByPeliculasId(Long movie) {
        return null;
    }

    @Override
    public void deleteById(Long id) throws Exception {

        if(id == null || id < 0 || id == 0){
            log.warn("Ha insertado un id erroneo");
            throw new Exception("Ha insertado un id erroneo");
        }
        try {
            pRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error delete ");
            throw new Exception( e.getCause());
        }


    }
}
