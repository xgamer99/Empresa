package com.coderhouse.clientes.dto;

import java.util.Date;
import java.util.List;

public class ComprobanteDTO {
    private int comprobanteId;

    private Date fecha;
    private List<ProductoDTO> descripcion;
    private double total;
    private int cantidad;
    private int clienteID;
    //Setters and Getters

    public int getComprobanteId() {
        return comprobanteId;
    }

    public void setComprobanteId(int comprobanteId) {
        this.comprobanteId = comprobanteId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<ProductoDTO> getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(List<ProductoDTO> descripcion) {
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
    //Constructor
    public ComprobanteDTO(int comprobanteId, Date fecha, List<ProductoDTO> descripcion, double total, int cantidad, int clienteID) {
        this.comprobanteId = comprobanteId;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.total = total;
        this.cantidad = cantidad;
        this.clienteID = clienteID;
    }
    public ComprobanteDTO() {
    }
}
