package com.example.escinf.laboratorio03.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.escinf.laboratorio03.R;
import com.example.escinf.laboratorio03.modelo.Carrera;

import java.util.ArrayList;
import java.util.List;


public class AgregarAlumno extends AppCompatActivity {

    ArrayAdapter<String> adapterCarrera;
    Spinner spinner;

    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_alumno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        spinner = (Spinner) findViewById(R.id.spinner_agregar_alumno);

        adapterCarrera = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapterCarrera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterCarrera);



    }

}
