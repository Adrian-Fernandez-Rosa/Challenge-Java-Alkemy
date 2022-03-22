package com.AdrianFernandezRosa.disney.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Imagen imagen;
    private String titulo;
    private String fechaCreacion;
    private Integer calificacion;

    @OneToMany
    private List<Personaje> personajesAsociados;

    public Pelicula() {
    }

    public Pelicula( Imagen imagen, String titulo, String fechaCreacion, Integer calificacion, List<Personaje> personajesAsociados) {

        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.personajesAsociados = personajesAsociados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public List<Personaje> getPersonajesAsociados() {
        return personajesAsociados;
    }

    public void setPersonajesAsociados(List<Personaje> personajesAsociados) {
        this.personajesAsociados = personajesAsociados;
    }
}
