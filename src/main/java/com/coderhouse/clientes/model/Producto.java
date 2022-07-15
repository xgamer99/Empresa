package com.coderhouse.clientes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto {
    @Column(name = "PRODUCTOID")
    @Id
    private int productoId;
    @Column(name = "CANTIDAD")
    private int fecha;
    @Column(name = "CODIGO")
    private int codigo;
    @Column(name = "PRECIO")
    private double precio;
    @Column(name = "DESCRIPCION")
    private String descripcion;

    //GETTERS AND SETTERS

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //Constructor

    public Producto() {
    }

    public Producto(int productoId, int fecha, int codigo, double precio, String descripcion) {
        this.productoId = productoId;
        this.fecha = fecha;
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;
    }
}
