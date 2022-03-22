package com.AdrianFernandezRosa.disney.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    @OneToOne
    private Imagen imagen;


    @OneToMany
    private List<Pelicula> peliculasAsociadas;

    public Genero() {
    }

    public Genero(String nombre, Imagen imagen, List<Pelicula> peliculasAsociadas) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculasAsociadas = peliculasAsociadas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Pelicula> getPeliculasAsociadas() {
        return peliculasAsociadas;
    }

    public void setPeliculasAsociadas(List<Pelicula> peliculasAsociadas) {
        this.peliculasAsociadas = peliculasAsociadas;
    }
}
