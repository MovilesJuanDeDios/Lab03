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
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;


import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.escinf.laboratorio03.R;
import com.example.escinf.laboratorio03.modelo.Carrera;
import com.example.escinf.laboratorio03.utils.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slon on 25/3/2018.
 */

public class CarreraListView extends AppCompatActivity {

    ArrayAdapter<Carrera> adapter;
    SwipeMenuListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listview = (SwipeMenuListView) findViewById(R.id.lista_carreras);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_carrera);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarreraListView.this, AgregarCarrera.class);
                startActivity(intent);
                finish();
            }
        });

        final SearchView searchCar = (SearchView)findViewById(R.id.buscar_carrera);
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
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Data.listaCarrera);
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

                SwipeMenuItem editarCursos = new SwipeMenuItem(getApplicationContext());
                // set item background
                editarCursos.setBackground(new ColorDrawable(Color.rgb(0x00, 0x00, 0x00)));
                // set item width
                editarCursos.setWidth(120);
                // set a icon
                editarCursos.setIcon(R.drawable.ic_action_edit_course);
                // add to menu
                menu.addMenuItem(editarCursos);

            }
        };

        listview.setMenuCreator(creator);

        listview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                String nombre;
                String codigo;
                String titulo;
                Boolean edit;

                switch (index) {
                    case 0:
                        nombre = Data.listaCarrera.get(position).getNombre();
                        codigo = Data.listaCarrera.get(position).getCodigo();
                        titulo = Data.listaCarrera.get(position).getTitulo();
                        edit = true;

                        Intent intent = new Intent(CarreraListView.this, AgregarCarrera.class);
                        intent.putExtra("nombre", nombre);
                        intent.putExtra("codigo", codigo);
                        intent.putExtra("titulo", titulo);
                        intent.putExtra("edit", edit);
                        intent.putExtra("position", position);
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        Data.listaCarrera.remove(position);
                        adapter.notifyDataSetChanged();
                        break;
                    case 2:

                        break;

                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

    }


    public void addData() {
        Carrera carrera = new Carrera();
        carrera.setNombre(getIntent().getStringExtra("nombre"));
        carrera.setCodigo(getIntent().getStringExtra("codigo"));
        carrera.setTitulo(getIntent().getStringExtra("titulo"));

        if (carrera.getNombre() != null)
            Data.listaCarrera.add(carrera);

        int position = getIntent().getIntExtra("position", -1);
        if(position != -1)
            Data.listaCarrera.remove(position);
    }

}

