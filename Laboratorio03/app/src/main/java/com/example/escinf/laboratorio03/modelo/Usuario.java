package com.example.escinf.laboratorio03.modelo;


import java.io.Serializable;

public class Usuario implements Serializable {

    private String cedula;
    private String clave;
    private int rol;

    public Usuario() {
    }

    public Usuario(String cedula, String clave, int rol) {
        this.cedula = cedula;
        this.clave = clave;
        this.rol = rol;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getRol() { return rol; }

    public void setRol(int rol) { this.rol = rol;  }

}
