package com.coderhouse.clientes.controller;

import com.coderhouse.clientes.dto.ComprobanteDTO;
import com.coderhouse.clientes.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coderhouse/comprobantes")
public class ComprobanteController {
    @Autowired
    private ComprobanteService comprobanteService;
    @GetMapping("")
    public List<ComprobanteDTO> buscarTodosLosComprobantes(){
        return comprobanteService.buscarTodosLosComprobantes();
    }
    @GetMapping("/{cID}")   //IDEs path parametro
    public ComprobanteDTO buscarPorId(@PathVariable int cID){
        return comprobanteService.buscarPorId(cID);
    }
}
