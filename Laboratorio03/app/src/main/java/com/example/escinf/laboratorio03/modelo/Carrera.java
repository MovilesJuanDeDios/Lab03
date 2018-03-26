package com.example.escinf.laboratorio03.modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

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
        return "Nombre: " + nombre + '\n' + "Codigo: " + codigo + "\n" + "Titulo: " + titulo;
    }

}
