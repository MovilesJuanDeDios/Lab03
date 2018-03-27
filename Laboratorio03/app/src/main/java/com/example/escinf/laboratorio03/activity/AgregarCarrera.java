package com.example.escinf.laboratorio03.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.escinf.laboratorio03.R;
import com.example.escinf.laboratorio03.modelo.Carrera;

public class AgregarCarrera extends AppCompatActivity {

    private Button btn_agregar;
    private Button btn_cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carrera);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        agregar();
        cancelar();
        if(getIntent().getBooleanExtra("edit",false))
            editData();
    }

    private void agregar() {
        btn_agregar = (Button) findViewById(R.id.button_aceptar_carrera);

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            private String nombre;
            private String codigo;
            private String titulo;
            private int position;

            @Override
            public void onClick(View v) {
                nombre = ((EditText) findViewById(R.id.nombre_carrera)).getText().toString();
                codigo = ((EditText) findViewById(R.id.codigo_carrera)).getText().toString();
                titulo = ((EditText) findViewById(R.id.titulo_carrera)).getText().toString();
                position = getIntent().getIntExtra("position",-1);

                Intent intent = new Intent(AgregarCarrera.this, CarreraListView.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("nombre", nombre);
                intent.putExtra("codigo", codigo);
                intent.putExtra("titulo", titulo);
                intent.putExtra("position", position);
                //startActivityIfNeeded(intent, 0);
                startActivity(intent);
                finish();
            }
        });
    }

    private void cancelar() {
        btn_cancelar = (Button) findViewById(R.id.button_cancelar_carrera);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgregarCarrera.this, CarreraListView.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void editData() {
        ((EditText)findViewById(R.id.nombre_carrera)).setText(getIntent().getStringExtra("nombre"));
        ((EditText)findViewById(R.id.codigo_carrera)).setText(getIntent().getStringExtra("codigo"));
        ((EditText)findViewById(R.id.codigo_carrera)).setEnabled(false);
        ((EditText)findViewById(R.id.titulo_carrera)).setText(getIntent().getStringExtra("titulo"));
    }
}



