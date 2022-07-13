package com.coderhouse.clientes.controller;

import com.coderhouse.clientes.model.Cliente;
import com.coderhouse.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("coderhouse/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("")
    public List<Cliente> buscarTodosLosclientes(){
        return clienteService.buscarTodosLosClientes();
    }
    @GetMapping("/{dni}")   //DniEs path parametro
    public Cliente buscarPorDni(@PathVariable Long dni){
        return clienteService.buscarPorDni(dni);

    }
}
