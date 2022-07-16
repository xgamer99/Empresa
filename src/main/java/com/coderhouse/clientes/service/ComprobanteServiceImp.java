package com.coderhouse.clientes.service;


import com.coderhouse.clientes.dto.ComprobanteDTO;
import com.coderhouse.clientes.model.Comprobante;
import com.coderhouse.clientes.model.Producto;
import com.coderhouse.clientes.repository.ComprobanteRepository;
import com.coderhouse.clientes.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComprobanteServiceImp implements ComprobanteService{
    @Autowired
    private ComprobanteRepository repository;
    @Autowired
    private ProductoRepository repoP;
    @Override
    public ComprobanteDTO buscarPorId(int id) {
        Comprobante comprobante = repository.findById(id).orElse(null);
        if(comprobante != null ){
            return pasarArgumentos(comprobante);
        }else{
            try {
                throw new Exception("El comprobante no existe");
            } catch (Exception e) {
                throw new RuntimeException(e);
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
    public List<Producto> obtenerProducto(Comprobante c){
        List<Producto> productoList = new ArrayList<>();
        Producto producto = new Producto();
        String stringProductos = c.getDescripcion();
        String[] productoListaString = obtenerProd(stringProductos);
        float[] idStPr = new float[3];
        for(int j=0;j<productoListaString.length;j++){                  //De la lista vuelve a saparar los productos separados por - para obtener los valores ID, Stock y Precio y se los asigna a un objeto
            idStPr =  IdStPrF(productoListaString[j].split("-"));
            productoList.add(new Producto((int)idStPr[0],(int)idStPr[1],repoP.getReferenceById((int)idStPr[0]).getCodigo(),idStPr[2], repoP.getReferenceById((int)idStPr[0]).getDescripcion()));
        }
        return productoList;
    }
    public String[] obtenerProd(String s){              //En el string los productos van diferenciados por ; es decir que {ID/Cantidad de Stock/ Precio Unitario}; {ID2/Cantidad de Stock2/ Precio Unitario2}
        String[] productos = s.split(";");          //Separa en una lista los producto
        return productos;
    }
    public float[] IdStPrF(String[] aux){         //Pasar de string a Int los valores de {ID/Cantidad de Stock/ Precio Unitario}
        float[] auxInt = new float[3];
        for(int i=0;i<aux.length;i++){
            auxInt[i] = Integer.parseInt(aux[i]);
        }
        return auxInt;
    }
    public double totalSuma(List<Producto> listaP){     //Suma los precios de los producto para obtener el total
        double totalSum = 0;
        for(int i = 0; i<listaP.size();i++){
            totalSum += listaP.get(i).getPrecio() * listaP.get(i).getCantidad();
        }
        return totalSum;
    }
    public int totalProd(List<Producto> listaP){        //Suma la cantidad de productos para obtener la cantidad de productos que se lleva el cliente
        int totalProdu = 0;
        for(int i = 0; i<listaP.size();i++){
            totalProdu += listaP.get(i).getCantidad();
        }
        return totalProdu;
    }
}