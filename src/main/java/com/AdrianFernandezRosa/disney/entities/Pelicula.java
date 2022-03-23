package com.AdrianFernandezRosa.disney.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Imagen imagen;
    private String titulo;
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    private Integer calificacion;

    @OneToMany
    private List<Personaje> personajesAsociados;

    public Pelicula() {
    }

    public Pelicula(Imagen imagen, String titulo, Date fechaCreacion, Integer calificacion, List<Personaje> personajesAsociados) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.personajesAsociados = personajesAsociados;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
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
