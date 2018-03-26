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
import com.example.escinf.laboratorio03.modelo.Carrera;
import com.example.escinf.laboratorio03.utils.Data;


/**
 * Created by slon on 25/3/2018.
 */

public class CarreraListView extends AppCompatActivity {

    ArrayAdapter<Carrera> adapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listview = (ListView) findViewById(R.id.lista_carreras);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_carrera);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarreraListView.this, AgregarAlumno.class);
                startActivity(intent);
            }
        });
        add();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Data.listaCarrera);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void add(){
        Carrera carrera = new Carrera("EIF","Informatica","Bachillerato");
        Carrera carrera2 = new Carrera("MAT","Matematica","Bachillerato");
        Carrera carrera3 = new Carrera("LIX","Ingles","Bachillerato");
        Data.listaCarrera.add(carrera);
        Data.listaCarrera.add(carrera2);
        Data.listaCarrera.add(carrera3);
    }
}
