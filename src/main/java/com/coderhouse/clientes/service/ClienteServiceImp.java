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
    public Cliente buscarPorClientID(int cID) {
        return repository.findById(cID).orElse(null);
    }

    @Override
    public List<Cliente> buscarTodosLosClientes() {
        return repository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        if (buscarPorClientID(cliente.getClienteid()) == null) {
            return this.repository.save(cliente);
        }else {
            return null;
        }
    }
}
