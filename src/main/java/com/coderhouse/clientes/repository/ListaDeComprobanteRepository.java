package com.coderhouse.clientes.repository;

import com.coderhouse.clientes.model.ListaProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaDeComprobanteRepository extends JpaRepository <ListaProductos, Integer>{

}
