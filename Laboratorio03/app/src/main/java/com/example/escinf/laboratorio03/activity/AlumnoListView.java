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
import com.example.escinf.laboratorio03.utils.Data;


/**
 * Created by slon on 25/3/2018.
 */

public class AlumnoListView extends AppCompatActivity {

    ArrayAdapter<Alumno> adapter;
    ListView listview;

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
        add();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Data.listaAlumno);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void add(){
        Carrera aux = new Carrera();
        Alumno alumno = new Alumno("123","Juan","8888-6661","juan@gmail.com","30/02/1992",aux);
        Alumno alumno2 = new Alumno("456","Andres","8347-6259","andres@gmail.com","25/02/1993",aux);
        Alumno alumno3 = new Alumno("789","Pedro","8959-7770","pedro@gmail.com","08/08/1998",aux);
        Alumno alumno4 = new Alumno("987","Jose","8587-8648","jose@gmail.com","06/09/1999",aux);
        Data.listaAlumno.add(alumno);
        Data.listaAlumno.add(alumno2);
        Data.listaAlumno.add(alumno3);
        Data.listaAlumno.add(alumno4);
    }
}
