package com.coderhouse.clientes.dto;


public class ProductoDTO {
    private String nombre;
    private int cantidad;
    private double precio;
    private int productoId;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, int cantidad, double precio, int productoId) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.productoId = productoId;
    }
}
