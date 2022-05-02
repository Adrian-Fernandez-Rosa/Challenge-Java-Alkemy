package com.AdrianFernandezRosa.disney.controllers;

import com.AdrianFernandezRosa.disney.dto.PersonajeAux;
import com.AdrianFernandezRosa.disney.entities.Personaje;
import com.AdrianFernandezRosa.disney.service.PersonajeServicio;
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
public class PersonajeController {

    private final Logger log = LoggerFactory.getLogger(PersonajeController.class);

    private PersonajeServicio personajeServicio;

    public PersonajeController(PersonajeServicio personajeServicio){
        this.personajeServicio = personajeServicio;
    }

    @PostMapping("/characters/create")
    public ResponseEntity<Personaje> crear(@RequestBody Personaje personaje){

        if(personaje.getId() != null){
            log.warn("Esta intentando crear un personaje que ya existe");
            return ResponseEntity.badRequest().build();
        }
        try {
            return ResponseEntity.ok(personajeServicio.save(personaje));
        }catch (Exception e){
            log.warn(e.getMessage());
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/characters")
    public ResponseEntity<List<PersonajeAux>> listadoPersonaje(@RequestParam(required = false ) String name,
                                                               @RequestParam(required = false ) Integer age,
                                                               @RequestParam(required = false) Long idMovie){


        List<PersonajeAux> personajes=  personajeServicio.findByAllParameters(name, age, idMovie);


        return new ResponseEntity<>(personajes, HttpStatus.OK);
    }




    /**
     * Actualiza el personaje con los atributos enviados sin afectar a los que no actualiza
     * @param personaje
     * @return
     */
    // TODO: personalizar error en controlador de errores
    // TODO: La imagen Debería ser un multipartFile para luego gestionarlo con api imgur
    @PutMapping("/characters/{id}")
    public ResponseEntity<Personaje> update(@PathVariable("id") Long id,@RequestBody Personaje personaje){

        try {
            personaje.setId(id);

            return ResponseEntity.ok(personajeServicio.modificarPersonaje(personaje));
        }catch (Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }

    /**
     * Obtener personaje por id (detalle)
     * @param id
     * @return personaje
     */
    @GetMapping("/characters/{id}")
    public ResponseEntity<Personaje> detallePersonaje(@PathVariable("id") Long id){

        try {
            System.out.println(id);
            if(id==null ){
                log.warn("El id no puede ser nulo");
                return ResponseEntity.badRequest().build();
            }

            return ResponseEntity.ok(personajeServicio.findById(id));
        }catch (NoSuchElementException e){

            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/characters/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        log.info("Solicitud REST para eliminar un personaje existente");

        try {
            this.personajeServicio.deleteById(id);
            return new ResponseEntity<>("Personaje borrado con éxito.", HttpStatus.NO_CONTENT);
        }catch (Exception e){

            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


}
