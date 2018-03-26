package com.example.escinf.laboratorio03.modelo;


import java.util.List;

public class Grupo {

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


}
