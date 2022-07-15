package com.coderhouse.clientes.service;

import com.coderhouse.clientes.model.Producto;
import com.coderhouse.clientes.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements ProductoService{
    @Autowired
    private ProductoRepository repository;
    @Override
    public Producto buscarPorId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> buscarTodosLosProductos() {
        return repository.findAll();
    }


}
