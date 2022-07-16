package com.coderhouse.clientes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "COMPROBANTE")
public class Comprobante {
    @Column(name = "COMPROBANTEID")
    @Id
    private int comprobanteId;
    @Column(name = "FECHA")
    private Date fecha;
    @Column(name = "LINEAS")        //En comprobanteDTO  se transforman las lineas en productos, el formato del string es "id del producto/cantidad del producto llevado/precio unitario"
    private String descripcion;
    @Column(name = "TOTAL")
    private double total;
    @Column(name = "CANTIDAD")      //Cantidad de producto llevado
    private int cantidad;
    @Column(name = "CLIENTEID")
    private int clienteID;
    //GETTERS AND SETTERS

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getComprobanteId() {
        return comprobanteId;
    }

    public void setComprobanteId(int comprobanteId) {
        this.comprobanteId = comprobanteId;
    }

    //Constructor

    public Comprobante() {
    }

    public Comprobante(Date fecha, String descripcion, double total, int cantidad, int clienteID, int comprobanteId) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.total = total;
        this.cantidad = cantidad;
        this.clienteID = clienteID;
        this.comprobanteId = comprobanteId;
    }
}
