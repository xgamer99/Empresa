package com.coderhouse.clientes.repository;

import com.coderhouse.clientes.model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobanteRepository extends JpaRepository <Comprobante, Integer>{

}
