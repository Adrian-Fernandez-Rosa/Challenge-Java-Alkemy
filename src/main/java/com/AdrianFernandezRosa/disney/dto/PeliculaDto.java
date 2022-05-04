package com.AdrianFernandezRosa.disney.dto;

import com.AdrianFernandezRosa.disney.entities.Imagen;

import java.util.Date;

public class PeliculaDto {

    private Imagen imagen;
    private String titulo;
    private Date fechaCreacion;

    public PeliculaDto() {
    }

    public PeliculaDto(Imagen imagen, String titulo, Date fechaCreacion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
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
}
