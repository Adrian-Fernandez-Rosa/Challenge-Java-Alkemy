package com.AdrianFernandezRosa.disney.entities;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity

public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Imagen imagen;

    @Column(unique = true)
    private String titulo;

    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    private Integer calificacion;

    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="pelicula_personaje"
            ,joinColumns = {@JoinColumn(name="id_pelicula")}
            ,inverseJoinColumns = {@JoinColumn(name="id_personaje")})
    // @JsonIgnoreProperties(value="peliculas")
  //  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
      // @JsonIgnore //con esto detiene el bucle pero se complica luego cuando quiera mostrar películas
    @Column(updatable = false)
    @JsonIgnoreProperties("peliculas")
    private Set<Personaje> personajesAsociados= new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pelicula_genero"
            ,joinColumns = {@JoinColumn(name="id_pelicula")}
            ,inverseJoinColumns = {@JoinColumn(name = "id_genero")})
    @Column(nullable = false)
    @JsonIgnoreProperties("peliculasAsociadasGenero")
    private Set<Genero> generos = new HashSet<>();

    public Pelicula() {
    }

    public Pelicula(Imagen imagen, String titulo, Date fechaCreacion, Integer calificacion, Set<Personaje> personajesAsociados) {
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

    public Set<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(Set<Genero> generos) {
        this.generos = generos;
    }

    // @JsonBackReference
    public Set<Personaje> getPersonajesAsociados() {
        return personajesAsociados;
    }

    public void setPersonajesAsociados(Set<Personaje> personajesAsociados) {
        this.personajesAsociados = personajesAsociados;
    }
}
