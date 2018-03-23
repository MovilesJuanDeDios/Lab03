package com.example.escinf.laboratorio03;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

public class Grupo extends AppCompatActivity {

    private Ciclo ciclo;
    private int numero;
    private String horario;
    private int Profesor;
    private List<Alumno> alumnos;

    public Grupo() {
    }

    public Grupo(Ciclo ciclo, int numero, String horario, int profesor, List<Alumno> alumnos) {
        this.ciclo = ciclo;
        this.numero = numero;
        this.horario = horario;
        Profesor = profesor;
        this.alumnos = alumnos;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getProfesor() {
        return Profesor;
    }

    public void setProfesor(int profesor) {
        Profesor = profesor;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentf = new Intent(Grupo.this,AgregarGrupo.class);
                startActivity(intentf);
            }
        });
    }

}
