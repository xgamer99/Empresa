package com.coderhouse.clientes.service;

import com.coderhouse.clientes.model.Comprobante;
import com.coderhouse.clientes.repository.ComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComprobanteServiceImp implements ComprobanteService{
    @Autowired
    private ComprobanteRepository repository;
    @Override
    public Comprobante buscarPorId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Comprobante> buscarTodosLosComprobantes() {
        return repository.findAll();
    }

}
