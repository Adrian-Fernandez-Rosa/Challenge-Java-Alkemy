package com.AdrianFernandezRosa.disney.controllers;

import com.AdrianFernandezRosa.disney.entities.Personaje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/characters")
public class PersonajeController {

    private final Logger log = LoggerFactory.getLogger(PersonajeController.class);



    @PostMapping("/")
    public ResponseEntity<Personaje> crear(@RequestBody Personaje personaje){
        return null;
    }

}
