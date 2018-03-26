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
import com.example.escinf.laboratorio03.modelo.Ciclo;
import com.example.escinf.laboratorio03.utils.Data;

/**
 * Created by slon on 25/3/2018.
 */

public class CicloListView extends AppCompatActivity {

    ArrayAdapter<Ciclo> adapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listview = (ListView) findViewById(R.id.lista_ciclos);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_ciclo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CicloListView.this, AgregarAlumno.class);
                startActivity(intent);
            }
        });
        add();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Data.listaCiclo);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void add(){
        Ciclo ciclo = new Ciclo(2014,1,"07/02/2014","20/06/2017");
        Ciclo ciclo2 = new Ciclo(2015,2,"24/07/2015","18/11/2015");
        Ciclo ciclo3 = new Ciclo(2016,1,"05/02/2016","15/06/2016");
        Ciclo ciclo4 = new Ciclo(2017,2,"27/07/2017","15/11/2017");
        Data.listaCiclo.add(ciclo);
        Data.listaCiclo.add(ciclo2);
        Data.listaCiclo.add(ciclo3);
        Data.listaCiclo.add(ciclo4);
    }
}
