package com.coderhouse.clientes.service;

import com.coderhouse.clientes.comprobanteJson.ComprobanteJson;
import com.coderhouse.clientes.dto.ComprobanteDTO;
import com.coderhouse.clientes.handle.ApiException;


import java.util.List;

public interface ComprobanteService {
    ComprobanteDTO buscarPorId(int id) throws ApiException;
    List<ComprobanteDTO> buscarTodosLosComprobantes();
    ComprobanteDTO hacerVenta(ComprobanteJson comprobante) throws ApiException;
}
