package com.coderhouse.clientes.comprobanteJson;

import java.util.List;

public class ComprobanteJson {
    private int clienteId;
    private List<ProductoJson> productos;

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public List<ProductoJson> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoJson> productos) {
        this.productos = productos;
    }

    public ComprobanteJson(int clienteId, List<ProductoJson> productos) {
        this.clienteId = clienteId;
        this.productos = productos;
    }

    public ComprobanteJson() {
    }
}
