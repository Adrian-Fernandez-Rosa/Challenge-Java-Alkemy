package com.AdrianFernandezRosa.disney.util;

import com.AdrianFernandezRosa.disney.entities.Personaje;

public class personajeUtils {

    public static Personaje clonar(Personaje pBD, Personaje update){

        if (update.getImagen() != null){
            pBD.setImagen(update.getImagen());
        }
        if (update.getNombre() != null){
            pBD.setNombre(update.getNombre());
        }
        if (update.getEdad() != null){
            pBD.setEdad(pBD.getEdad());
        }
        if (update.getPeso() != null){
            pBD.setPeso(update.getPeso());
        }
        if (update.getHistoria() != null){
            pBD.setHistoria(update.getHistoria());
        }

        return pBD;
    }

}
