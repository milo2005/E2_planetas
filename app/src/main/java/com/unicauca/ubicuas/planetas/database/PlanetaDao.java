package com.unicauca.ubicuas.planetas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unicauca.ubicuas.planetas.models.Planeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dario Chamorro on 23/09/2015.
 */
public class PlanetaDao {

    public static final String TBL_NAME="planeta";
    public static final String C_NOMBRE="nombre";
    public static final String C_GRAVEDAD="gravedad";
    public static final String C_TAMANIO="tamanio";

    SQLiteDatabase db;

    public PlanetaDao(Context context){
        DatabaseHelper helper =  new DatabaseHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insertPlaneta(Planeta planeta){
        ContentValues cV = new ContentValues();
        cV.put(C_NOMBRE, planeta.getNombre());
        cV.put(C_GRAVEDAD, planeta.getGravedad());
        cV.put(C_TAMANIO, planeta.getTamanio());

        long id = db.insert(TBL_NAME, null, cV);
        planeta.setId(id);
    }

    public void updatePlaneta(Planeta planeta){
        ContentValues cV = new ContentValues();
        cV.put(C_NOMBRE, planeta.getNombre());
        cV.put(C_GRAVEDAD, planeta.getGravedad());
        cV.put(C_TAMANIO, planeta.getTamanio());

        db.update(TBL_NAME, cV, "_id=?", new String[]{"" + planeta.getId()});
    }

    public void deletePlaneta(long id){
        db.delete(TBL_NAME, "_id=?", new String[]{"" + id});
    }

    public List<Planeta> getAllPlaneta(){
        String sql = "SELECT * FROM "+TBL_NAME;
        return  cursorToList(sql);
    }

    public List<Planeta> getAllPlanetaByName(String name){
        String sql ="SELECT * FROM "+TBL_NAME+" WHERE "+C_NOMBRE+" LIKE '%"+name+"%'";
        return  cursorToList(sql);
    }

    private List<Planeta> cursorToList(String sql){
        List<Planeta> data =  new ArrayList<>();

        Cursor cursor = db.rawQuery(sql, null);

        for(int i=0; i<cursor.getCount();i++){
            cursor.moveToPosition(i);

            Planeta p = new Planeta();
            p.setId(cursor.getLong(0));
            p.setNombre(cursor.getString(1));
            p.setGravedad(cursor.getFloat(2));
            p.setTamanio(cursor.getLong(3));

            data.add(p);
        }

        return data;
    }


}
