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
import java.util.List;

public class Carrera extends AppCompatActivity {

    private String codigo;
    private String nombre;
    private String titulo;
    private List<Curso> cursos;

    public Carrera() {
    }

    public Carrera(String codigo, String nombre, String titulo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        this.cursos = new ArrayList<Curso>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentf = new Intent(Carrera.this,AgregarCarrera.class);
                startActivity(intentf);
            }
        });

        /*
        Tabla tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
        tabla.agregarCabecera(R.array.headerCarrera);

            ArrayList<String> elementos = new ArrayList<String>();
            elementos.add("Casilla [0]");
            elementos.add("Casilla [1]");
            tabla.agregarFilaTabla(elementos);
*/


        Tabla tabla = new TablaCarrera(this);
        tabla.agregarCabecera(R.array.headerCarrera);
       // for(int i = 0; i < 10; i++) {
        acti
            ArrayList<Carrera> carreras = new ArrayList<>();
            carreras.add(new Carrera("EIF", "Ingenieria en Sistemas", "Titulo X"));

            tabla.agregarFilaTabla(carreras);
        // }

    }

}
