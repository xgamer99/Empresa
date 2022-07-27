package com.coderhouse.clientes.comprobanteJson;

public class ProductoJson {
    private int cantidad;
    private int idProducto;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public ProductoJson() {
    }

    public ProductoJson(int cantidad, int idProducto) {
        this.cantidad = cantidad;
        this.idProducto = idProducto;
    }
}
