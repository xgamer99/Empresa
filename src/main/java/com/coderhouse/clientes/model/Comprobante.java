package com.coderhouse.clientes.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "COMPROBANTE")
@NamedQuery(name="Comprobante.findAll", query="SELECT c FROM Comprobante c")
public class Comprobante {
    @Id
    @Column(name = "COMPROBANTEID")
    private int comprobanteId;
    @Column(name = "FECHA")
    private Date fecha;
    @Column(name = "TOTAL")
    private double total;
    @Column(name = "CANTIDAD")      //Cantidad de producto llevado
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "CLIENTEID")
    private Cliente clienteID;
    @OneToMany(mappedBy = "comprobante", cascade = CascadeType.ALL)
    private List<ListaProductos> listaProductos;
    //GETTERS AND SETTERS

    public List<ListaProductos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ListaProductos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        return clienteID.getClienteid();
    }

    public void setClienteID(Cliente clienteID) {
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

    public Comprobante(Date fecha, double total, int cantidad, Cliente clienteID) {
        this.fecha = fecha;
        this.total = total;
        this.cantidad = cantidad;
        this.clienteID= (clienteID);
    }
}
