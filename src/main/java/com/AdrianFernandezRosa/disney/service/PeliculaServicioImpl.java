package com.AdrianFernandezRosa.disney.service;

import com.AdrianFernandezRosa.disney.entities.Pelicula;
import com.AdrianFernandezRosa.disney.repository.PeliculaRepository;

import java.util.List;

public class PeliculaServicioImpl implements PeliculaServicio{

    private PeliculaRepository pRepository;

    public PeliculaServicioImpl(PeliculaRepository pRepository) {
        this.pRepository = pRepository;
    }

    @Override
    public List<Pelicula> findAll() {
        return pRepository.findAll();
    }

    @Override
    public List<Pelicula> findByNombreStartingWith(String name) {
        return null;
    }

    @Override
    public Pelicula editarPelicula(Pelicula pelicula) {
        return null;
    }

    @Override
    public List<Pelicula> findByAllParameters(String name, Long idGenero, Boolean orden) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void agregarPelicula(Long idP, Long idPersonaje) {

    }

    @Override
    public void removerPelicula(Long idP, Long idPersonaje) {

    }

    @Override
    public void eliminarPelicula(Pelicula pelicula) {

    }
}
