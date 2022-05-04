package com.AdrianFernandezRosa.disney.service;

import com.AdrianFernandezRosa.disney.dto.PeliculaDto;
import com.AdrianFernandezRosa.disney.entities.Pelicula;
import com.AdrianFernandezRosa.disney.repository.PeliculaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PeliculaServicioImpl implements PeliculaServicio{

    private PeliculaRepository pRepository;

    public PeliculaServicioImpl(PeliculaRepository pRepository) {
        this.pRepository = pRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Pelicula guardarPelicula(Pelicula pelicula) throws Exception{
        validarSave(pelicula);
        return pRepository.save(pelicula);
    }

    public void validarSave(Pelicula pelicula) throws Exception {

        if(pelicula.getId() != null){
            throw new Exception("El id debe ser nulo");
        }

        if(pRepository.existsPeliculaByTituloIgnoreCase(pelicula.getTitulo())){
            throw new Exception("Este Título ya existe");
        }

        if(pelicula.getTitulo() == null){
            throw new Exception("El título no puede ser nulo");
        }
        if(pelicula.getFechaCreacion().after(new Date())){
            throw new Exception(("La fecha no puede ser posterior a la fecha actual"));
        }

        if(!(pelicula.getCalificacion()>0 && pelicula.getCalificacion()<=5)){
            throw new Exception("La calificación debe ser entre 1 y 5");
        }
        if(pelicula.getGeneros().isEmpty()){
            throw new Exception("La película debe tener al menos un genero");
        }


    }

    @Override
    @Transactional(readOnly = true)
    public Pelicula findById(Long id) {
        Optional<Pelicula> pelicula = pRepository.findById(id);

        if(pelicula.isPresent()){
            return pelicula.get();
        } else {
            throw new NoSuchElementException("No se encontró la película");
        }
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



    //TODO: Refactorizar con solid
    @Override
    public List<PeliculaDto> findByAllParameters(String name, Long idGenero, String orden) throws Exception {

        Sort order = null;
        List<Pelicula> peliculas = new ArrayList<>();
        if(orden != null){

            if (orden.equals("ASC")){
                System.out.println("ascendente");
                order=Sort.by(Sort.Direction.ASC , "FechaCreacion");

            } else if (orden.equals("DESC")) {
                order=Sort.by(Sort.Direction.DESC , "FechaCreacion");

            } else {
                throw new Exception("Parámetro no permitido");
            }
        }

        if(name == null && idGenero == null){

            if(order == null ) {
                return mapper(pRepository.findAll());
            }else{
                return mapper(pRepository.findAll(order));
            }
        }

        if(name != null){
            peliculas = pRepository.findByTituloStartingWith(name , order);
        }
        if (idGenero != null){

            if(!peliculas.isEmpty()){

                Predicate<Pelicula> filter = pelicula -> {
                    return pelicula.getGeneros().stream().anyMatch(g -> g.getId().equals(idGenero));
                };
                peliculas = peliculas.stream().filter(filter).collect(Collectors.toList());


            } else {
                peliculas = pRepository.findByGenerosId(idGenero, order);
            }

        }
        return mapper(peliculas);

    }

    private List<PeliculaDto> mapper(List<Pelicula> peliculas){
        List<PeliculaDto> pAux = new ArrayList<>();

        for (Pelicula pelicula: peliculas) {
            PeliculaDto p = new PeliculaDto();
            p.setTitulo(pelicula.getTitulo());
            p.setImagen(pelicula.getImagen());
            p.setFechaCreacion(pelicula.getFechaCreacion());
            pAux.add(p);

        }
        return pAux;
    }


    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void agregarPersonaje(Long idP, Long idPersonaje) {

    }

    @Override
    public void removerPersonaje(Long idP, Long idPersonaje) {

    }

    @Override
    public void eliminarPelicula(Pelicula pelicula) {

    }
}
