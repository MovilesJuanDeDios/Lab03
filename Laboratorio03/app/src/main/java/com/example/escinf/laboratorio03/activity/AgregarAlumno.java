package com.example.escinf.laboratorio03.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.escinf.laboratorio03.R;
import com.example.escinf.laboratorio03.modelo.Carrera;
import com.example.escinf.laboratorio03.utils.Data;

import java.util.ArrayList;
import java.util.List;


public class AgregarAlumno extends AppCompatActivity {

    private Button btn_agregar;
    private Button btn_cancelar;

    private String cedula;
    private String nombre;
    private String telefono;
    private String email;
    private String fechaNac;
    private Carrera carrera;
    private int position;

    ArrayAdapter<String> adapterCarrera;
    Spinner spinner;

    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_alumno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner = (Spinner) findViewById(R.id.spinner_carrera_alumno);

        if (Data.listaCarrera.size() == 0) {
            list.add(" ");
        }

        for (int i = 0; i < Data.listaCarrera.size(); i++) {
            list.add(Data.listaCarrera.get(i).getNombre());
        }

        adapterCarrera = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapterCarrera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterCarrera);

        agregar();
        cancelar();
        if(getIntent().getBooleanExtra("edit",false))
            editData();
    }

    private void agregar() {
        btn_agregar = (Button) findViewById(R.id.button_aceptar_alumno);

        btn_agregar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cedula = ((EditText) findViewById(R.id.cedula_alumno)).getText().toString();
                nombre = ((EditText) findViewById(R.id.nombre_alumno)).getText().toString();
                telefono = ((EditText) findViewById(R.id.telefono_alumno)).getText().toString();
                email = ((EditText) findViewById(R.id.email_alumno)).getText().toString();
                fechaNac = ((EditText) findViewById(R.id.fechaNac_alumno)).getText().toString();
                carrera = getCarrera(spinner.getSelectedItem().toString());
                position = getIntent().getIntExtra("position",-1);

                if (validate()) {

                    Intent intent = new Intent(AgregarAlumno.this, AlumnoListView.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    intent.putExtra("cedula", cedula);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("telefono", telefono);
                    intent.putExtra("email", email);
                    intent.putExtra("fechaNac", fechaNac);
                    intent.putExtra("carrera", carrera);
                    intent.putExtra("position", position);
                    //startActivityIfNeeded(intent, 0);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void cancelar() {
        btn_cancelar = (Button) findViewById(R.id.button_cancelar_alumno);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgregarAlumno.this, AlumnoListView.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private Carrera getCarrera(String nombre) {
        for (int i = 0; i < Data.listaCarrera.size(); i++) {
            if ((Data.listaCarrera.get(i).getNombre()).equals(nombre)){
                return Data.listaCarrera.get(i);
            }
        }
        return null;
    }

    public void editData() {
        ((EditText) findViewById(R.id.nombre_alumno)).setText(getIntent().getStringExtra("nombre"));
        ((EditText) findViewById(R.id.cedula_alumno)).setText(getIntent().getStringExtra("cedula"));
        ((EditText) findViewById(R.id.cedula_alumno)).setEnabled(false);
        ((EditText) findViewById(R.id.telefono_alumno)).setText(getIntent().getStringExtra("telefono"));
        ((EditText) findViewById(R.id.email_alumno)).setText(getIntent().getStringExtra("email"));
        ((EditText) findViewById(R.id.fechaNac_alumno)).setText(getIntent().getStringExtra("fechaNac"));
    }

    private boolean validate() {
        boolean go = true;

        if (TextUtils.isEmpty(cedula)) {
            go = false;
        }
        if (TextUtils.isEmpty(nombre)) {
            go = false;
        }
        if (TextUtils.isEmpty(telefono)) {
            go = false;
        }
        if (TextUtils.isEmpty(email)) {
            go = false;
        }
        if (TextUtils.isEmpty(fechaNac)) {
            go = false;
        }

        if(spinner.getSelectedItem().equals(" ")) {
            go = false;
        }

        return go;
    }

}
