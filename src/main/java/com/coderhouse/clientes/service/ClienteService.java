package com.coderhouse.clientes.service;

import com.coderhouse.clientes.handle.ApiException;
import com.coderhouse.clientes.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente buscarPorClientID(int cID);
    List<Cliente> buscarTodosLosClientes();

    Cliente save(Cliente cliente);
    Cliente modify(Cliente cliente, int cID) throws ApiException;
    void delete(int cID) throws ApiException;
}
