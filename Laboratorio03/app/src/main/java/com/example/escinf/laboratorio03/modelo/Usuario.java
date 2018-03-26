package com.example.escinf.laboratorio03.modelo;


public class Usuario {

    private String cedula;
    private String clave;

    public Usuario() {
    }

    public Usuario(String cedula, String clave) {
        this.cedula = cedula;
        this.clave = clave;
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


}
