package com.coderhouse.clientes.service;

import com.coderhouse.clientes.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente buscarPorDni(Long dni);
    List<Cliente> buscarTodosLosClientes();
}
