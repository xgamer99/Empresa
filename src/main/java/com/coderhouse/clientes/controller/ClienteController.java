package com.coderhouse.clientes.controller;

import com.coderhouse.clientes.handle.ApiException;
import com.coderhouse.clientes.model.Cliente;
import com.coderhouse.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empresa/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("")
    public List<Cliente> buscarTodosLosclientes(){
        return clienteService.buscarTodosLosClientes();
    }
    @GetMapping("/{cID}")   //IDEs path parametro
    public Cliente buscarPorId(@PathVariable int cID){
        return clienteService.buscarPorClientID(cID);

    }
    @PostMapping("/add")
    public Cliente newEntity(@RequestBody Cliente cliente) {
        return this.clienteService.save(cliente);
    }
    @PostMapping("/modify/{cID}")
    public Cliente modificar(@RequestBody Cliente cliente,@PathVariable int cID) throws ApiException {
        return this.clienteService.modify(cliente,cID);
    }
    @PostMapping("/delete/{cID}")
    public void delete(@PathVariable int cID) throws ApiException {
        this.clienteService.delete(cID);
    }
}
