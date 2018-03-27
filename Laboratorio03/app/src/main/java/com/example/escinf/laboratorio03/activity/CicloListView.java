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

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.escinf.laboratorio03.R;
import com.example.escinf.laboratorio03.modelo.Ciclo;
import com.example.escinf.laboratorio03.utils.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by slon on 25/3/2018.
 */

public class CicloListView extends AppCompatActivity {

    ArrayAdapter<Ciclo> adapter;
    SwipeMenuListView listview;

    private static boolean added = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listview = (SwipeMenuListView) findViewById(R.id.lista_ciclos);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_ciclo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CicloListView.this, AgregarCiclo.class);
                startActivity(intent);
                finish();
            }
        });

        if (!added) {
            add();
            added = true;
        }
        addData();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Data.listaCiclo);
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
                int anno;
                String numero;
                String fechaInicio;
                String fechaFin;
                Boolean edit;

                switch (index) {
                    case 0:
                        anno = Data.listaCiclo.get(position).getAnno();
                        numero = Data.listaCiclo.get(position).getNumero();
                        fechaInicio = Data.listaCiclo.get(position).getFechaInicio();
                        fechaFin = Data.listaCiclo.get(position).getFechaFin();
                        edit = true;

                        Intent intent = new Intent(CicloListView.this, AgregarCiclo.class);
                        intent.putExtra("anno", anno);
                        intent.putExtra("numero", numero);
                        intent.putExtra("fechaInicio", fechaInicio);
                        intent.putExtra("fechaFin", fechaFin);
                        intent.putExtra("edit", edit);
                        intent.putExtra("position", position);
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        Data.listaCiclo.remove(position);
                        adapter.notifyDataSetChanged();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

    }


    public void addData() {
        Ciclo ciclo = new Ciclo();
        ciclo.setAnno(getIntent().getIntExtra("anno", 0));
        ciclo.setNumero(getIntent().getStringExtra("numero"));
        ciclo.setFechaInicio(getIntent().getStringExtra("fechaInicio"));
        ciclo.setFechaFin(getIntent().getStringExtra("fechaFin"));
        int position = getIntent().getIntExtra("position", -1);
        if(position != -1)
            Data.listaCiclo.remove(position);
        if (ciclo.getFechaInicio() != null)
            Data.listaCiclo.add(ciclo);
    }

    public void add(){
        Ciclo ciclo = new Ciclo(2014,"Primero","07/02/2014","20/06/2017");
        Ciclo ciclo2 = new Ciclo(2015,"Segundo","24/07/2015","18/11/2015");
        Ciclo ciclo3 = new Ciclo(2016,"Primero","05/02/2016","15/06/2016");
        Ciclo ciclo4 = new Ciclo(2017,"Segundo","27/07/2017","15/11/2017");
        Data.listaCiclo.add(ciclo);
        Data.listaCiclo.add(ciclo2);
        Data.listaCiclo.add(ciclo3);
        Data.listaCiclo.add(ciclo4);

    }
}

