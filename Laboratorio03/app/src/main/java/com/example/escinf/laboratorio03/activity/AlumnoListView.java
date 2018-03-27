package com.example.escinf.laboratorio03.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.escinf.laboratorio03.R;
import com.example.escinf.laboratorio03.modelo.Alumno;
import com.example.escinf.laboratorio03.modelo.Carrera;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by slon on 25/3/2018.
 */

public class AlumnoListView extends AppCompatActivity {

    ArrayAdapter<Alumno> adapter;
    ListView listview;

    public static final List<Alumno> listaAlumno = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listview = (ListView) findViewById(R.id.lista_alumnos);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_alumno);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlumnoListView.this, AgregarAlumno.class);
                startActivity(intent);
            }
        });

/*
        add();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Datos.listaAlumno);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();*/
    }


}
