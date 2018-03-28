package com.example.escinf.laboratorio03.modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grupo implements Serializable {

    private Ciclo ciclo;
    private Curso curso;
    private int numero;
    private String horario;
    private Profesor Profesor;
    private List<Alumno> alumnos;

    public Grupo() {
    }

    public Grupo(Ciclo ciclo, Curso curso, int numero, String horario, Profesor profesor) {
        this.ciclo = ciclo;
        this.curso = curso;
        this.numero = numero;
        this.horario = horario;
        this.Profesor = profesor;
        alumnos = new ArrayList<>();
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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

    public Profesor getProfesor() {
        return Profesor;
    }

    public void setProfesor(Profesor profesor) {
        Profesor = profesor;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Ciclo: " + ciclo.toString() + "\n" +
                "Curso: " + curso.getNombre() + "\n" +
                "Profesor: " + Profesor.getNombre();
    }
}
