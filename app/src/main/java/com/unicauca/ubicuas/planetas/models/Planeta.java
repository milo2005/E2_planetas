package com.unicauca.ubicuas.planetas.models;

/**
 * Created by Dario Chamorro on 23/09/2015.
 */
public class Planeta {

    long id;
    long tamanio;
    String nombre;
    float gravedad;

    public Planeta() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTamanio() {
        return tamanio;
    }

    public void setTamanio(long tamanio) {
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getGravedad() {
        return gravedad;
    }

    public void setGravedad(float gravedad) {
        this.gravedad = gravedad;
    }
}
