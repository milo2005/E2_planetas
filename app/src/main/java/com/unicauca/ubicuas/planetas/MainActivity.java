package com.unicauca.ubicuas.planetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.unicauca.ubicuas.planetas.database.PlanetaDao;
import com.unicauca.ubicuas.planetas.models.Planeta;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PlanetaDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = new PlanetaDao(this);

        List<Planeta> data = dao.getAllPlaneta();

        for(int i=0; i<data.size();i++){
            Log.i("Planeta", "----------------");
            Log.i("Planeta","ID:"+data.get(i).getId());
            Log.i("Planeta","NOMBRE:"+data.get(i).getNombre());
            Log.i("Planeta","GRAVEDAD:"+data.get(i).getGravedad());
            Log.i("Planeta","TAMANIO:"+data.get(i).getTamanio());
        }


    }


}
