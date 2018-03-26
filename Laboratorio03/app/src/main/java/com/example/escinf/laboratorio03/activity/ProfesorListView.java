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
import com.example.escinf.laboratorio03.modelo.Profesor;
import com.example.escinf.laboratorio03.utils.Data;


/**
 * Created by slon on 25/3/2018.
 */

public class ProfesorListView extends AppCompatActivity {

    ArrayAdapter<Profesor> adapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listview = (ListView) findViewById(R.id.lista_profesores);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_profesor);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfesorListView.this, AgregarProfesor.class);
                startActivity(intent);
                finish();

            }
        });

        addData();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Data.listaProf);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    public void addData() {
        Profesor profesor = new Profesor();
        profesor.setNombre(getIntent().getStringExtra("nombre"));
        profesor.setCedula(getIntent().getStringExtra("cedula"));
        profesor.setTelefono(getIntent().getStringExtra("telefono"));
        profesor.setEmail(getIntent().getStringExtra("email"));
        if (profesor.getCedula() != null)
            Data.listaProf.add(profesor);

    }
}
