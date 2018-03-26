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
import com.example.escinf.laboratorio03.modelo.Curso;
import com.example.escinf.laboratorio03.utils.Data;

/**
 * Created by slon on 25/3/2018.
 */

public class CursoListView extends AppCompatActivity {

    ArrayAdapter<Curso> adapter;
    SwipeMenuListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listview = (SwipeMenuListView) findViewById(R.id.lista_cursos);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_curso);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CursoListView.this, AgregarCurso.class);
                startActivity(intent);
                finish();
            }
        });
        add();
        addData();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Data.listaCurso);
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
        Curso curso = new Curso();
        curso.setNombre(getIntent().getStringExtra("nombre"));
        curso.setCodigo(getIntent().getStringExtra("codigo"));
        curso.setCreditos(getIntent().getIntExtra("creditos", 0));
        curso.setHorasSemanales(getIntent().getIntExtra("horasSemanales", 0));
        if (curso.getNombre() != null)
            Data.listaCurso.add(curso);
    }

    public void add(){
        Curso curso = new Curso("EIF604","Dispositivos_Moviles",4,12);
        Curso curso2 = new Curso("EI605","Metodos_Investigacion",4,12);
        Curso curso3 = new Curso("EIF606","Ingenieria3",4,12);
        Curso curso4 = new Curso("EIF607","Paradigmas",4,12);
        Data.listaCurso.add(curso);
        Data.listaCurso.add(curso2);
        Data.listaCurso.add(curso3);
        Data.listaCurso.add(curso4);
    }
}