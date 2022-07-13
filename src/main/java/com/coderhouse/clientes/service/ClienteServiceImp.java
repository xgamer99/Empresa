package com.coderhouse.clientes.service;

import com.coderhouse.clientes.model.Cliente;
import com.coderhouse.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImp implements ClienteService{
    @Autowired
    private ClienteRepository repository;
    @Override
    public Cliente buscarPorDni(Long dni) {
        return repository.findById(dni).orElse(null);
    }

    @Override
    public List<Cliente> buscarTodosLosClientes() {
        return repository.findAll();
    }
}
