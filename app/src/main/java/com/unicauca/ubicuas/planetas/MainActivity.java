package com.unicauca.ubicuas.planetas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.unicauca.ubicuas.planetas.models.Planeta;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Planeta.init(this);
        List<Planeta> data = Planeta.listAll(Planeta.class);

        for(int i = 0; i<data.size();i++){
            Log.i("Planeta","-----------------");
            Log.i("Planeta","ID:"+data.get(i).getId());
            Log.i("Planeta","NOMBRE:"+data.get(i).getNombre());
            Log.i("Planeta","GRAVEDAD:"+data.get(i).getGravedad());
            Log.i("Planeta","TAMANIO"+data.get(i).getTamanio());
        }

    }


}
