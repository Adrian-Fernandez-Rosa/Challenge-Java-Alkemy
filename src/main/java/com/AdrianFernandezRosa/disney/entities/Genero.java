package com.AdrianFernandezRosa.disney.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero" )
    private Long id;
    private String nombre;

    @OneToOne
    private Imagen imagen;

    /*
    (extracto de google para justificar manytomany)
    ¿Cuántos géneros puede tener una película?
    Y es que, los géneros cinematográficos no son exclusivos y,
     por lo tanto, una obra puede estar catalogada en dos o más géneros
      a la vez dependiendo de las características que se tomen en cuenta.
     */

    @ManyToMany(mappedBy = "generos", fetch = FetchType.EAGER)
    private Set<Pelicula> peliculasAsociadasGenero = new HashSet<>();

    public Genero() {
    }

    public Genero(String nombre, Imagen imagen, Set<Pelicula> peliculasAsociadasGenero) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculasAsociadasGenero = peliculasAsociadasGenero;
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

    public Set<Pelicula> getPeliculasAsociadasGenero() {
        return peliculasAsociadasGenero;
    }

    public void setPeliculasAsociadasGenero(Set<Pelicula> peliculasAsociadas) {
        this.peliculasAsociadasGenero = peliculasAsociadas;
    }
}
