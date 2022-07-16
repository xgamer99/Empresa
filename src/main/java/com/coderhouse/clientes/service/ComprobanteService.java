package com.coderhouse.clientes.service;

import com.coderhouse.clientes.dto.ComprobanteDTO;


import java.util.List;

public interface ComprobanteService {
    ComprobanteDTO buscarPorId(int id);
    List<ComprobanteDTO> buscarTodosLosComprobantes();
}
