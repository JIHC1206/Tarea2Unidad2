package com.example.tarea2unidad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
    }
    public void listado (View view){
        Intent i = new Intent(this, Listado.class);
        startActivity(i);
    }
    public void Ubicacion (View view){
        Intent i = new Intent(this, GPS.class);
        startActivity(i);
    }
}