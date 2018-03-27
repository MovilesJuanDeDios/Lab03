package com.example.escinf.laboratorio03.modelo;


import java.io.Serializable;

public class Profesor implements Serializable {

    private String cedula;
    private String nombre;
    private String telefono;
    private String email;

    public Profesor() {
    }

    public Profesor(String cedula, String nombre, String telefono, String email) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cedula: " + cedula + '\n' +
                "Nombre: " + nombre + '\n' +
                "Email: " + email;
    }
}
