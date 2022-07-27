package com.coderhouse.clientes.service;


import com.coderhouse.clientes.comprobanteJson.ComprobanteJson;
import com.coderhouse.clientes.comprobanteJson.ProductoJson;
import com.coderhouse.clientes.dto.ComprobanteDTO;
import com.coderhouse.clientes.dto.ProductoDTO;
import com.coderhouse.clientes.handle.ApiException;
import com.coderhouse.clientes.model.Cliente;
import com.coderhouse.clientes.model.Comprobante;
import com.coderhouse.clientes.model.ListaProductos;
import com.coderhouse.clientes.model.Producto;
import com.coderhouse.clientes.repoExterno.ClockWorldRest;
import com.coderhouse.clientes.repository.ClienteRepository;
import com.coderhouse.clientes.repository.ComprobanteRepository;
import com.coderhouse.clientes.repository.ListaDeComprobanteRepository;
import com.coderhouse.clientes.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComprobanteServiceImp implements ComprobanteService{
    @Autowired
    private ComprobanteRepository repository;       //Repositorio de comprobantes
    @Autowired
    private ListaDeComprobanteRepository repoP;     //Repositorio de lista de productos vendidos
    @Autowired
    private ProductoRepository repoStock;           //Repositorio de stock
    @Autowired
    private ClienteRepository repositoryCliente;    //Repositorio de clientes
    @Autowired
    private ClockWorldRest clockWorldApi;           //Repositorio para obtener la fecha
    @Override
    public ComprobanteDTO buscarPorId(int id) throws ApiException {
        Comprobante comprobante = repository.findById(id).orElse(null);
        if(comprobante != null ){
            return pasarArgumentos(comprobante);
        }else{
            try {
                throw new ApiException("Cliente no existe");
            } catch (Exception e) {
                throw new ApiException(e.getMessage());
            }
        }
    }
    @Override
    public List<ComprobanteDTO> buscarTodosLosComprobantes() {
        List<Comprobante> lista = repository.findAll();
        List<ComprobanteDTO> listaDto = new ArrayList<>();
        for(int i=0;i< lista.size();i++){
            listaDto.add(pasarArgumentos(lista.get(i)));
        }
        return listaDto;
    }

    @Override
    public ComprobanteDTO hacerVenta(ComprobanteJson comprobante) throws ApiException {         //Hacer la venta, calcular stock, verificar
        ComprobanteDTO comprobanteDTO = new ComprobanteDTO();
        Comprobante comprobanteRepo = new Comprobante();
        if(repositoryCliente.findById(comprobante.getClienteId()).orElse(null)!= null){       //Si el numero del cliente existe, entonces se verifica
            if(existeProducto(comprobante.getProductos())){
            if (comprobarStock(comprobante.getProductos())) {     //Comprobar Stock
                comprobanteRepo.setComprobanteId(calIdComp(repository.findAll()));
                comprobanteRepo.setClienteID(devuelveCliente(this.repositoryCliente.findAll(),comprobante.getClienteId()));
                comprobanteRepo.setListaProductos(transformarProductos(comprobante.getProductos(), comprobanteRepo));
                try {                                                                  //Intenta obtener una fecha valida
                    comprobanteRepo.setFecha(clockWorldApi.getFecha());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                //Convertimos para mostrarlo en pantalla
                comprobanteDTO = pasarArgumentos(comprobanteRepo);
                comprobanteDTO.setDescripcion(covertirLista(comprobanteRepo.getListaProductos()));
                comprobanteDTO.setTotal(totalSuma(comprobanteDTO.getDescripcion()));
                comprobanteDTO.setCantidad(totalProd(comprobanteDTO.getDescripcion()));
                calcularYGuardarStock(comprobanteRepo.getListaProductos());
                //Guardamos
                repository.save(comprobanteRepo);
                return comprobanteDTO;
            } else {
                    throw new ApiException("No hay stock disponible de alguno de los productos");
            }
        } else {
                    throw new ApiException("No existe alguno de los productos");
            }
        }else {
                throw new ApiException("No existe el cliente");
        }
    }
//Funciones auxiliares
    public ComprobanteDTO pasarArgumentos(Comprobante c){               //Convertimos el comprobante del repositorio en un objeto con estructura json
        ComprobanteDTO comprobanteDTO = new ComprobanteDTO();
        comprobanteDTO.setComprobanteId(c.getComprobanteId());
        comprobanteDTO.setFecha(c.getFecha());
        comprobanteDTO.setClienteID(c.getClienteID());
        comprobanteDTO.setDescripcion(obtenerProducto(c));
        comprobanteDTO.setTotal(totalSuma(obtenerProducto(c)));
        comprobanteDTO.setCantidad(totalProd(comprobanteDTO.getDescripcion()));
        return comprobanteDTO;
    }
    public List<ProductoDTO> obtenerProducto(Comprobante c){                    //Funcion auxiliar para pasar una lista de productos de un formato a otro
        List<ListaProductos> productoListaTodos= this.repoP.findAll();
        List<ListaProductos> productoList= new ArrayList<>();
        List<ProductoDTO> productoListDTO = new ArrayList<>();
        for(int e=0; e<productoListaTodos.size();e++){                          //Dentro de toda la base de lineas, busca aquellos productos que tengan el comprobante ID que se requiere y los pasa a una nueva lista auxialiar
            if(obtenerProductosDelComprobante(c.getComprobanteId(),productoListaTodos.get(e))){
                productoList.add(productoListaTodos.get(e));
            }
        }
        ProductoDTO producto = new ProductoDTO();
        for(int i=0;i<productoList.size();i++){
            producto.setNombre(productoList.get(i).getNombreProducto());
            producto.setPrecio(productoList.get(i).getPrecio());
            producto.setCantidad(productoList.get(i).getCantidad());
            producto.setProductoId(productoList.get(i).getProductoID());
            productoListDTO.add(new ProductoDTO((producto.getNombre()), producto.getCantidad(), producto.getPrecio(), producto.getProductoId()));
        }
        return productoListDTO;
    }

    public List<ListaProductos> transformarProductos(List<ProductoJson> prod,Comprobante idComprobante){    //Funcion auxiliar para convertir la lista de datos de pantalla al formato a trabajar
        List<ListaProductos> transfo = new ArrayList<>();
        for(int i=0; i<prod.size();i++){
            transfo.add(new ListaProductos(repoStock.findById(prod.get(i).getIdProducto()).get().getDescripcion(), repoStock.findById(prod.get(i).getIdProducto()).get().getPrecio(), prod.get(i).getCantidad(), prod.get(i).getIdProducto(),idComprobante));      //(Nombre Producto, precio, cantidad, producto id)
        }
        return transfo;
    }
    public Boolean obtenerProductosDelComprobante(int idComprobante, ListaProductos prod){
            if (prod.getComprobanteID() == idComprobante){
                return true;
            }
        return false;
    }
    public double totalSuma(List<ProductoDTO> listaP){     //Suma los precios de los producto para obtener el total
        double totalSum = 0;
        for(int i = 0; i<listaP.size();i++){
            totalSum += listaP.get(i).getPrecio() * listaP.get(i).getCantidad();
        }
        return totalSum;
    }
    public int totalProd(List<ProductoDTO> listaP){        //Suma la cantidad de productos para obtener la cantidad de productos que se lleva el cliente
        int totalProdu = 0;
        for(int i = 0; i<listaP.size();i++){
            totalProdu += listaP.get(i).getCantidad();
        }
        return totalProdu;
    }
    public boolean existeProducto(List<ProductoJson> prodRequeridos){            //Busca en el repositorio si existen los id de los productos
        boolean bandera = true;
        for(int i= 0; i<prodRequeridos.size();i++ ){
            for(int e=0;e<this.repoStock.findAll().size();e++){
                if(this.repoStock.findById(prodRequeridos.get(i).getIdProducto()).orElse(null) == null){
                    bandera = false;
                }
            }
        }
        return bandera;
    }
    public int calIdComp(List<Comprobante> comprobantes){           //Calcula el indice nuevo del comprobante para no sobreescribir otro comprobante
        int indice = comprobantes.size()+1;
        return indice;
    }
    public boolean comprobarStock(List<ProductoJson> prodRequeridos){        //Comprobamos que los items requeridos esten en stock, sino anulamos la compra
        boolean bandera = true;
        List<Producto> stock = this.repoStock.findAll();
        for(int i= 0; i<prodRequeridos.size() && bandera ==true;i++ ){
            for(int e=0;e<stock.size()&&bandera==true;e++){
                if(prodRequeridos.get(i).getIdProducto()==stock.get(e).getProductoId()){            //Busco que los productos tengan igual productoId para fijar si hay stock de ese producto
                    if(prodRequeridos.get(i).getCantidad()>stock.get(e).getCantidad()){
                        bandera = false;
                    }
                }
            }
        }
        return bandera;
    }
    public void calcularYGuardarStock(List<ListaProductos> prodRequeridos){          //Calcula el stock de los productos solicitados y se guarda el nuevo stock
        List<Producto> stock = this.repoStock.findAll();
        List<Producto> stocknuevo = new ArrayList<>();
        for(int i= 0; i<prodRequeridos.size();i++ ){
            for(int e=0;e<stock.size();e++){
                if(prodRequeridos.get(i).getProductoID()==stock.get(e).getProductoId()){            //Busco que los productos tengan igual productoId para fijar si hay stock de ese producto
                    stock.get(e).setCantidad(stock.get(e).getCantidad()-prodRequeridos.get(i).getCantidad());
                    stocknuevo.add(stock.get(e));
                }
            }
        }
        this.repoStock.saveAllAndFlush(stocknuevo);
    }
    public Cliente devuelveCliente(List<Cliente> clientes, int IdCliente){                      //Busca el cliente por ID y lo devuelve
        Cliente cliente = new Cliente();
        for (int i=0;i< clientes.size();i++){
            if(clientes.get(i).getClienteid() == IdCliente){
                cliente = clientes.get(i);
            }
        }
        return cliente;
    }
    public List<ProductoDTO> covertirLista(List<ListaProductos> listaProductosSinTrafo){            //Funcion auxiliar para convertir una lista de repositorio a una lista para mostrar
        List<ProductoDTO> lista = new ArrayList<>();
        for(int i =0; i< listaProductosSinTrafo.size();i++){
            lista.add(new ProductoDTO(listaProductosSinTrafo.get(i).getNombreProducto(),listaProductosSinTrafo.get(i).getCantidad(),listaProductosSinTrafo.get(i).getPrecio(),listaProductosSinTrafo.get(i).getProductoID()));//String nombre, int cantidad, double precio, int productoId
        }
        return lista;
    }
}