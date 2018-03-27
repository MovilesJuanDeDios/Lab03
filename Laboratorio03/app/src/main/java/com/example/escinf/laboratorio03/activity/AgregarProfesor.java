package com.example.escinf.laboratorio03.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.escinf.laboratorio03.R;
import com.example.escinf.laboratorio03.modelo.Profesor;


public class AgregarProfesor extends AppCompatActivity {

    private Button btn_agregar;
    private Button btn_cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_profesor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        agregar();
        cancelar();
        if(getIntent().getBooleanExtra("edit",false))
            editData();
    }

    private void agregar() {
        btn_agregar = (Button) findViewById(R.id.button_aceptar_profesor);

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            private String nombre;
            private String cedula;
            private String telefono;
            private String email;
            private int position;

            @Override
            public void onClick(View v) {
                nombre = ((EditText) findViewById(R.id.nombre_profesor)).getText().toString();
                cedula = ((EditText) findViewById(R.id.cedula_profesor)).getText().toString();
                telefono = ((EditText) findViewById(R.id.telefono_profesor)).getText().toString();
                email = ((EditText) findViewById(R.id.email_profesor)).getText().toString();
                position = getIntent().getIntExtra("position",-1);

                Intent intent = new Intent(AgregarProfesor.this, ProfesorListView.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("nombre", nombre);
                intent.putExtra("cedula", cedula);
                intent.putExtra("telefono", telefono);
                intent.putExtra("email", email);
                intent.putExtra("position", position);
                //startActivityIfNeeded(intent, 0);
                startActivity(intent);
                finish();
            }
        });
    }

    private void cancelar() {
        btn_cancelar = (Button) findViewById(R.id.button_cancelar_profesor);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgregarProfesor.this, ProfesorListView.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void editData() {
        ((EditText)findViewById(R.id.nombre_profesor)).setText(getIntent().getStringExtra("nombre"));
        ((EditText)findViewById(R.id.cedula_profesor)).setText(getIntent().getStringExtra("cedula"));
        ((EditText)findViewById(R.id.cedula_profesor)).setEnabled(false);
        ((EditText)findViewById(R.id.telefono_profesor)).setText(getIntent().getStringExtra("telefono"));
        ((EditText)findViewById(R.id.email_profesor)).setText(getIntent().getStringExtra("email"));
    }

}
