package com.AdrianFernandezRosa.disney.dto;

import com.AdrianFernandezRosa.disney.entities.Imagen;

public class PersonajeAux {

    private String nombre;
    private Imagen imagen;


    public PersonajeAux() {
    }

    public PersonajeAux(String nombre, Imagen imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
}
