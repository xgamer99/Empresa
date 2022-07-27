package com.coderhouse.clientes.controller;

import com.coderhouse.clientes.comprobanteJson.ComprobanteJson;
import com.coderhouse.clientes.dto.ComprobanteDTO;
import com.coderhouse.clientes.handle.ApiException;
import com.coderhouse.clientes.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empresa/comprobantes")
public class ComprobanteController {
    @Autowired
    private ComprobanteService comprobanteService;
    @GetMapping("")
    public List<ComprobanteDTO> buscarTodosLosComprobantes(){
        return comprobanteService.buscarTodosLosComprobantes();
    }
    @GetMapping("/{cID}")   //IDEs path parametro
    public ComprobanteDTO buscarPorId(@PathVariable int cID) throws ApiException {
        return comprobanteService.buscarPorId(cID);
    }
    @PostMapping("/add")
    public ComprobanteDTO hacerVenta(@RequestBody ComprobanteJson comprobante) throws ApiException {
        return comprobanteService.hacerVenta(comprobante);
    }
}
