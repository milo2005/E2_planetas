package com.unicauca.ubicuas.planetas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.SensorManager;

/**
 * Created by Dario Chamorro on 23/09/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    static final String DB_NAME="planetas.db";
    static int version = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql ="CREATE TABLE "+PlanetaDao.TBL_NAME
                +" (_id INTEGER AUTO_INCREMENT PRIMARY KEY,"
                +PlanetaDao.C_NOMBRE+" TEXT,"
                +PlanetaDao.C_GRAVEDAD+" FLOAT,"
                +PlanetaDao.C_TAMANIO+" LONG"
                +")";

        db.execSQL(sql);

        ContentValues cV = new ContentValues();
        cV.put(PlanetaDao.C_NOMBRE,"Marte");
        cV.put(PlanetaDao.C_TAMANIO,20345l);
        cV.put(PlanetaDao.C_GRAVEDAD, SensorManager.GRAVITY_MARS);

        db.insert(PlanetaDao.TBL_NAME, null, cV);

        cV = new ContentValues();
        cV.put(PlanetaDao.C_NOMBRE,"Tierra");
        cV.put(PlanetaDao.C_TAMANIO,18002l);
        cV.put(PlanetaDao.C_GRAVEDAD, SensorManager.GRAVITY_EARTH);

        db.insert(PlanetaDao.TBL_NAME, null, cV);

        cV = new ContentValues();
        cV.put(PlanetaDao.C_NOMBRE,"Jupiter");
        cV.put(PlanetaDao.C_TAMANIO,2034523l);
        cV.put(PlanetaDao.C_GRAVEDAD, SensorManager.GRAVITY_JUPITER);

        db.insert(PlanetaDao.TBL_NAME, null, cV);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+PlanetaDao.TBL_NAME);
        onCreate(db);
    }
}
