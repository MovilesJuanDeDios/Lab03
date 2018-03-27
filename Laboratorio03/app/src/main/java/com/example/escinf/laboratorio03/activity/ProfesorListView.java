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

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.escinf.laboratorio03.R;
import com.example.escinf.laboratorio03.modelo.Profesor;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by slon on 25/3/2018.
 */

public class ProfesorListView extends AppCompatActivity {

    ArrayAdapter<Profesor> adapter;
    SwipeMenuListView listview;

    public static final List<Profesor> listaProf = new ArrayList<>();

    private static boolean added = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listview = (SwipeMenuListView) findViewById(R.id.lista_profesores);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_profesor);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfesorListView.this, AgregarProfesor.class);
                startActivity(intent);
                finish();

            }
        });
        if (!added) {
            add();
            added = true;
        }
        addData();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaProf);
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
                String nombre;
                String cedula;
                String telefono;
                String email;
                Boolean edit;

                switch (index) {
                    case 0:
                        nombre = listaProf.get(position).getNombre();
                        cedula = listaProf.get(position).getCedula();
                        telefono = listaProf.get(position).getTelefono();
                        email = listaProf.get(position).getEmail();
                        edit = true;

                        Intent intent = new Intent(ProfesorListView.this, AgregarProfesor.class);
                        intent.putExtra("nombre", nombre);
                        intent.putExtra("cedula", cedula);
                        intent.putExtra("telefono", telefono);
                        intent.putExtra("email", email);
                        intent.putExtra("edit", edit);
                        intent.putExtra("position", position);
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        listaProf.remove(position);
                        adapter.notifyDataSetChanged();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

    }

    public void addData() {
        Profesor profesor = new Profesor();
        profesor.setNombre(getIntent().getStringExtra("nombre"));
        profesor.setCedula(getIntent().getStringExtra("cedula"));
        profesor.setTelefono(getIntent().getStringExtra("telefono"));
        profesor.setEmail(getIntent().getStringExtra("email"));
        int position = getIntent().getIntExtra("position", -1);
        if(position != -1)
            listaProf.remove(position);
        if (profesor.getCedula() != null)
            listaProf.add(profesor);
    }

    public void add(){
        Profesor profesor = new Profesor("753","Juan","85749545","juan@gmail.com");
        Profesor profesor2 = new Profesor("159","Carlos","83264585","carlos@gmail.com");
        Profesor profesor3 = new Profesor("852","Johnny","86593457","johnny@gmail.com");
        Profesor profesor4 = new Profesor("486","Jose","85472163","jose@gmail.com");
        listaProf.add(profesor);
        listaProf.add(profesor2);
        listaProf.add(profesor3);
        listaProf.add(profesor4);
    }



}
