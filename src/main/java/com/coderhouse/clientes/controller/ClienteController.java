package com.coderhouse.clientes.controller;

import com.coderhouse.clientes.model.Cliente;
import com.coderhouse.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Cliente buscarPorDni(@PathVariable int cID){
        return clienteService.buscarPorClientID(cID);

    }
    @PostMapping("/add")
    public Cliente newEntity(@RequestBody Cliente cliente) {
        return this.clienteService.save(cliente);
    }
}
