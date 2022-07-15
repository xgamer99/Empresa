package com.coderhouse.clientes.service;

import com.coderhouse.clientes.model.Cliente;
import com.coderhouse.clientes.model.Comprobante;

import java.util.List;

public interface ComprobanteService {
    Comprobante buscarPorId(int id);
    List<Comprobante> buscarTodosLosComprobantes();
}
