package com.coderhouse.clientes.repository;

import com.coderhouse.clientes.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Integer>{

}
