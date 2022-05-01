package com.AdrianFernandezRosa.disney.controllers;

import com.AdrianFernandezRosa.disney.dto.PersonajeAux;
import com.AdrianFernandezRosa.disney.entities.Personaje;
import com.AdrianFernandezRosa.disney.service.PersonajeServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class PersonajeController {

    private final Logger log = LoggerFactory.getLogger(PersonajeController.class);

    private PersonajeServicio personajeServicio;

    public PersonajeController(PersonajeServicio personajeServicio){
        this.personajeServicio = personajeServicio;
    }

    @PostMapping("/")
    public ResponseEntity<Personaje> crear(@RequestBody Personaje personaje){
        return null;
    }

    @GetMapping("/characters")
    public ResponseEntity<List<PersonajeAux>> listadoPersonaje(@RequestParam(required = false ) String name,
                                                               @RequestParam(required = false ) Integer age,
                                                               @RequestParam(required = false) Long idMovie){


        List<PersonajeAux> personajes=  personajeServicio.findByAllParameters(name, age, idMovie);


        return new ResponseEntity<>(personajes, HttpStatus.OK);
    }


    @GetMapping("/a")
    public ResponseEntity<List<PersonajeAux>> listadoPersonaje(){
        System.out.println("*****************************************************************");

        return new ResponseEntity<>(new ArrayList<PersonajeAux>(), HttpStatus.OK);
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




}
