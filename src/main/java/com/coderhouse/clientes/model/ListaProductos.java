package com.coderhouse.clientes.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "LISTADECOMPROBANTE")
public class ListaProductos { //nombreproducto varchar(150), precio DOUBLE not null, cantidad int not null, productoid int not null, comprobanteid int not null, primary key (comprobanteid)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer lineaid;
    @Column(name = "NOMBREPRODUCTO")
    private String nombreProducto;
    @Column(name = "PRECIO")
    private Double precio;
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "PRODUCTOID")
    private int productoID;
    @ManyToOne
    @JoinColumn (name = "COMPROBANTEID")
    private Comprobante comprobante;

    public ListaProductos(String nombreProducto, Double precio, int cantidad, int productoID, Optional<Comprobante> byId) {

    }
    //GETTERS AND SETTERS

    public Integer getLineaid() {
        return lineaid;
    }

    public void setLineaid(Integer lineaid) {
        this.lineaid = lineaid;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public int getComprobanteID() {
        return comprobante.getComprobanteId();
    }

    public void setComprobanteID(int comprobanteID) {
        this.comprobante.setComprobanteId(comprobanteID);
    }
    //CONSTRUCTOR

    public ListaProductos() {
    }
    public ListaProductos( String nombreProducto, Double precio, int cantidad, int productoID, Comprobante comprobanteID) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.productoID = productoID;
        this.comprobante= comprobanteID;
    }

    public ListaProductos(int cantidad, int productoID) {
        this.cantidad = cantidad;
        this.productoID = productoID;
    }
    public ListaProductos(String nombreProducto, Double precio, int cantidad, int productoID) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.productoID = productoID;
    }
}
