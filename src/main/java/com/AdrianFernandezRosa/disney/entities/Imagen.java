package com.AdrianFernandezRosa.disney.entities;

import javax.persistence.*;

@Entity
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Long id;
    private String urlI;

    public Imagen() {
    }

    public Imagen(String urlI) {
        this.urlI = urlI;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlI() {
        return urlI;
    }

    public void setUrlI(String urlI) {
        this.urlI = urlI;
    }
}
