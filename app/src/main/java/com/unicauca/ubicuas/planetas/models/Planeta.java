package com.unicauca.ubicuas.planetas.models;

import android.content.Context;
import android.hardware.SensorManager;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Dario Chamorro on 23/09/2015.
 */
public class Planeta extends SugarRecord{

    long tamanio;
    String nombre;
    float gravedad;

    public Planeta() {}

    //region Getters & Setters

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
    //endregion

    public static void init(Context context){

        SugarContext.init(context);

        if(count(Planeta.class)==0) {
            Planeta p = new Planeta();
            p.setNombre("Tierra");
            p.setGravedad(SensorManager.GRAVITY_EARTH);
            p.setTamanio(23232l);
            p.save();

            p = new Planeta();
            p.setNombre("Marte");
            p.setGravedad(SensorManager.GRAVITY_MARS);
            p.setTamanio(23232l);
            p.save();

            p = new Planeta();
            p.setNombre("Jupiter");
            p.setGravedad(SensorManager.GRAVITY_JUPITER);
            p.setTamanio(23232l);
            p.save();
        }
    }

    public static List<Planeta> getAllPlanetaByNombre(String name){
        List<Planeta> data = findWithQuery(Planeta.class
                , "SELECT * FROM Planeta WHERE nombre LIKE '%"+name+"%'", null);
        return  data;
    }
}
