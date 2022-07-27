package com.coderhouse.clientes.service;

import com.coderhouse.clientes.handle.ApiException;
import com.coderhouse.clientes.model.Producto;

import java.util.List;

public interface ProductoService {
    Producto buscarPorId(int id);
    List<Producto> buscarTodosLosProductos();
    Producto save(Producto producto);
    Producto modify(Producto producto, int cID) throws ApiException;
    void delete( int cID) throws ApiException;
}
