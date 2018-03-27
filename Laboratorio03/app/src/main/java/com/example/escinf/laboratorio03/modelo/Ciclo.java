package com.example.escinf.laboratorio03.modelo;


import java.io.Serializable;

public class Ciclo implements Serializable {

    private int anno;
    private int numero;
    private String fechaInicio;
    private String fechaFin;

    public Ciclo() {
    }

    public Ciclo(int anno, int numero, String fechaInicio, String fechaFin) {
        this.anno = anno;
        this.numero = numero;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        if (numero == 1)
            return "Pimer ciclo - "  + anno;
        else
            return "Segundo ciclo - "  + anno;
    }

}
