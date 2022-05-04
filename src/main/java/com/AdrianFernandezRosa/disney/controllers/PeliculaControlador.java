package com.AdrianFernandezRosa.disney.controllers;

import com.AdrianFernandezRosa.disney.dto.PeliculaDto;
import com.AdrianFernandezRosa.disney.entities.Imagen;
import com.AdrianFernandezRosa.disney.entities.Pelicula;
import com.AdrianFernandezRosa.disney.service.PeliculaServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class PeliculaControlador {

    private final Logger log = LoggerFactory.getLogger(PeliculaControlador.class);

    private PeliculaServicio peliculaServicio;

    public PeliculaControlador(PeliculaServicio peliculaServicio){
        this.peliculaServicio = peliculaServicio;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<PeliculaDto>> listadoPeliculas(@RequestParam(required = false) String name,
                                                              @RequestParam(required = false) Long idGenero,
                                                              @RequestParam(required = false) String orden){ //mejorar con ENUM

        try{
            List<PeliculaDto> peliculas = peliculaServicio.findByAllParameters(name, idGenero, orden);
            return new ResponseEntity<>(peliculas, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
           return  ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Pelicula> detallePelicula(@PathVariable("id") Long id){

        try{
            if(id == null){
                log.warn("El id no puede ser nulo");
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(peliculaServicio.findById(id));

        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();

        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }


     
}
