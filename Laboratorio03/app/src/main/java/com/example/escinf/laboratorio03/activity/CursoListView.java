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
import com.example.escinf.laboratorio03.modelo.Curso;
import com.example.escinf.laboratorio03.utils.Data;

/**
 * Created by slon on 25/3/2018.
 */

public class CursoListView extends AppCompatActivity {

    ArrayAdapter<Curso> adapter;
    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listview = (ListView) findViewById(R.id.lista_cursos);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_curso);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CursoListView.this, AgregarCurso.class);
                startActivity(intent);
                finish();
            }
        });

        addData();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Data.listaCurso);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    public void addData() {
        Curso curso = new Curso();
        curso.setNombre(getIntent().getStringExtra("nombre"));
        curso.setCodigo(getIntent().getStringExtra("codigo"));
        curso.setCreditos(getIntent().getIntExtra("creditos", 0));
        curso.setHorasSemanales(getIntent().getIntExtra("horasSemanales", 0));
        if (curso.getNombre() != null)
            Data.listaCurso.add(curso);

    }
}
