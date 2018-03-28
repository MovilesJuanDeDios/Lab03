package com.example.escinf.laboratorio03.activity;

import android.content.Intent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.escinf.laboratorio03.R;
import com.example.escinf.laboratorio03.modelo.Ciclo;
import com.example.escinf.laboratorio03.modelo.Curso;
import com.example.escinf.laboratorio03.modelo.Grupo;
import com.example.escinf.laboratorio03.modelo.Profesor;
import com.example.escinf.laboratorio03.utils.Data;

/**
 * Created by slon on 25/3/2018.
 */

public class GrupoListView extends AppCompatActivity {

    ArrayAdapter<Grupo> adapter;
    SwipeMenuListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listview = (SwipeMenuListView) findViewById(R.id.lista_grupos);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_grupo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GrupoListView.this, AgregarGrupo.class);
                startActivity(intent);
                finish();
            }
        });

        addData();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Data.listaGrupo);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    public void addData() {
        Grupo grupo = new Grupo();
        grupo.setCiclo((Ciclo) getIntent().getSerializableExtra("ciclo"));
        grupo.setCurso((Curso) getIntent().getSerializableExtra("curso"));
        grupo.setNumero(getIntent().getIntExtra("numero", 0));
        grupo.setHorario(getIntent().getStringExtra("horario"));
        grupo.setProfesor((Profesor) getIntent().getSerializableExtra("profesor"));
        if (grupo.getHorario() != null)
            Data.listaGrupo.add(grupo);
    }

}
