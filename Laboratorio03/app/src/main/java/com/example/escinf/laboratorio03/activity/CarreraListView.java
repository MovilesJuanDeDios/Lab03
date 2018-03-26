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

import android.widget.ListView;


import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.escinf.laboratorio03.R;
import com.example.escinf.laboratorio03.modelo.Carrera;
import com.example.escinf.laboratorio03.utils.Data;

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

            }
        };

        listview.setMenuCreator(creator);

        listview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // accion editar
                        break;
                    case 1:
                        // accion eliminar
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

