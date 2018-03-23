package com.example.escinf.laboratorio03;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableLayout;

import java.util.ArrayList;

public class Profesor extends AppCompatActivity {

    private String cedula;
    private String nombre;
    private int telefono;
    private String email;

    public Profesor() {
    }

    public Profesor(String cedula, String nombre, int telefono, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentf = new Intent(Profesor.this,AgregarProfesor.class);
                startActivity(intentf);
            }
        });

      /*  Tabla tabla = new TablaCarrera(this, (TableLayout)findViewById(R.id.tabla));
        tabla.agregarCabecera(R.array.headerProfesor);
        for(int i = 0; i < 10; i++) {
            ArrayList<String> profesores = new ArrayList<String>();
            profesores.add(Integer.toString(i));
            profesores.add("Profesor [" + i + ", 0]");
            profesores.add("Profesor [" + i + ", 1]");

            tabla.agregarFilaTabla(profesores);
        }
        */
    }

}
