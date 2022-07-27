package com.coderhouse.clientes.service;

import com.coderhouse.clientes.handle.ApiException;
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

    @Override
    public Producto save(Producto producto) {
        if (buscarPorId(producto.getProductoId()) == null) { // Busca si no existe un producto con ese ID
            return this.repository.save(producto);      //Como no existe guarda el producto
        }else {                             //Como el producto ya existe, avisa que existe y no guarda
            try {
                throw new Exception("El producto ya existe");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public Producto modify(Producto producto, int cID) throws ApiException {
        return verificarID(producto,cID);
    }

    @Override
    public void delete(int cID) throws ApiException {
        if(this.repository.findById(cID).orElse(null) != null){
            repository.delete(buscarPorId(cID));
            throw new ApiException("Producto Eliminado");
        }else{
            throw new ApiException("No existe el producto");
        }
    }

    public Producto verificarID(Producto p, int cID) throws ApiException {          //Se verifica que la modificacion de datos o ID no interfiera con otro producto existente
        //Primero verifico que el id del producto modificado y el cID sean iguales
        if(p.getProductoId()==cID){
            return this.repository.save(p);
        }else{      //En caso que no sean iguales los id, es decir cambiar productoid a otro, verifico que no exista uno con la id nueva
            if (buscarPorId(p.getProductoId()) == null) {      //Busco en la id nueva, si es que existe un producto con esa id, en caso de que no exista se puede cambiar la id del producto
                repository.delete(buscarPorId(cID));        //Borro el producto para que no este dupliado al cambiar la id
                return this.repository.save(p);             //Guardo el producto con su nueva ID
            }else{              //La modificacion tiene un id nuevo pero existe un producto con esa id, entonces no se puede hacer esa modificacion
                throw new ApiException("Ya existe un producto con la misma id");
            }
        }
    }

}
