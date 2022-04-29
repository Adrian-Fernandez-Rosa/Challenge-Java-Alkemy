package com.AdrianFernandezRosa.disney.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Personaje implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personaje")
    private Long id;

    @OneToOne
    private Imagen imagen;
    @Column (unique = true, nullable = false )
    private String nombre;

    private Integer edad;
    @Column (nullable = false)
    private Double peso;
    @Column (length = 2048)
    private String historia;

    @ManyToMany(mappedBy = "personajesAsociados", fetch = FetchType.EAGER)
    private Set<Pelicula> peliculas= new HashSet<>();

    public Personaje() {
    }

    public Personaje(Imagen imagen, String nombre, Integer edad, Double peso, String historia, Set<Pelicula> peliculas) {

        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculas = peliculas;
    }

    public Personaje(Long id, Imagen imagen, String nombre, Integer edad, Double peso, String historia, Set<Pelicula> peliculas) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculas = peliculas;
    }

    public Personaje(Imagen imagen, String nombre, Integer edad, Double peso, String historia) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Set<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Set<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}
