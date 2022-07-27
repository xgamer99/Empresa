package com.coderhouse.clientes.service;

import com.coderhouse.clientes.handle.ApiException;
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
            try {
                throw new Exception("El cliente ya existe");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public Cliente modify(Cliente cliente, int cID) throws ApiException {
        return verificarID(cliente,cID);
    }

    @Override
    public void delete(int cID) throws ApiException {
        if(this.repository.findById(cID).orElse(null) != null){
            repository.delete(buscarPorClientID(cID));
            throw new ApiException("Cliente Eliminado");
        }else{
            throw new ApiException("No existe ese cliente");
        }
    }

    public Cliente verificarID(Cliente c, int cID) throws ApiException {          //Se verifica que la modificacion de datos o ID no interfiera con otro cliente existente
        //Primero verifico que el id del ciente modificado y el cID sean iguales
        if(c.getClienteid()==cID){
            //throw new Exception("Ya existe un cliente con la misma id");
            return this.repository.save(c);
        }else{      //En caso que no sean iguales los id, es decir quiera mover un clienteid a otra posicion, verifico que no exista uno con la id nueva
            if (buscarPorClientID(c.getClienteid()) == null) {      //Busco en la id nueva, si es que existe un cliente con esa id, en caso de que no exista se puede mover el cliente a esa posicion
                repository.delete(buscarPorClientID(cID));
                return this.repository.save(c);
            }else{              //La modificacion tiene un id nuevo pero existe un cliente, entonces no se puede hacer esa modificacion
                throw new ApiException("Ya existe un cliente con la misma id");
            }
        }
    }
}
