package com.coderhouse.clientes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "DNI")
    private int dni;
    @Column(name = "CLIENTEID")
    @Id
    private int clienteid;
    //GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    //Constructor
    public Cliente(String nombre, String apellido, int edad, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.clienteid = clienteid;
        this.dni = dni;
    }

    public Cliente() {
    }
}
