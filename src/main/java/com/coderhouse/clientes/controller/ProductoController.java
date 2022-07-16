package com.coderhouse.clientes.controller;

import com.coderhouse.clientes.model.Producto;
import com.coderhouse.clientes.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coderhouse/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @GetMapping("")
    public List<Producto> buscarTodosLosProductos(){
        return productoService.buscarTodosLosProductos();
    }
    @GetMapping("/{cID}")   //IDEs path parametro
    public Producto buscarPorId(@PathVariable int cID){
        return productoService.buscarPorId(cID);
    }
    @PostMapping("/add")
    public Producto newEntity(@RequestBody Producto producto) {
        return this.productoService.save(producto);
    }
    @PostMapping("/modify/{cID}")
    public Producto modificar(@RequestBody Producto producto,@PathVariable int cID) throws Exception {
        return this.productoService.modify(producto,cID);
    }
}
