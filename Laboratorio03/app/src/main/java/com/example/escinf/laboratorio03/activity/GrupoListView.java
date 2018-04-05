package com.example.escinf.laboratorio03.activity;

import android.content.Intent;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SearchView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
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

        final SearchView searchCar = (SearchView)findViewById(R.id.buscar_grupos);
        searchCar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        addData();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Data.listaGrupo);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {

                // create "edit" item
                SwipeMenuItem editItem = new SwipeMenuItem(getApplicationContext());
                // set item background
                editItem.setBackground(new ColorDrawable(Color.rgb(0x00, 0x00, 0x00)));
                // set item width
                editItem.setWidth(120);
                // set a icon
                editItem.setIcon(R.drawable.ic_action_edit);
                // add to menu
                menu.addMenuItem(editItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0x00, 0x00, 0x00)));
                // set item width
                deleteItem.setWidth(120);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_action_delete);
                // add to menu
                menu.addMenuItem(deleteItem);

            }
        };

        listview.setMenuCreator(creator);

        listview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                Ciclo ciclo;
                Curso curso;
                int numero;
                String horario;
                Profesor profesor;

                Boolean edit;

                switch (index) {
                    case 0:
                        ciclo = Data.listaGrupo.get(position).getCiclo();
                        curso = Data.listaGrupo.get(position).getCurso();
                        numero = Data.listaGrupo.get(position).getNumero();
                        horario = Data.listaGrupo.get(position).getHorario();
                        profesor = Data.listaGrupo.get(position).getProfesor();
                        edit = true;
                        String numeroS = Integer.toString(numero);


                        Intent intent = new Intent(GrupoListView.this, AgregarGrupo.class);
                        intent.putExtra("ciclo", ciclo);
                        intent.putExtra("curso", curso);
                        intent.putExtra("numero", numeroS);
                        intent.putExtra("horario", horario);
                        intent.putExtra("profesor", profesor);
                        intent.putExtra("edit", edit);
                        intent.putExtra("position", position);
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        Data.listaGrupo.remove(position);
                        adapter.notifyDataSetChanged();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
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
