package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes,Integer> {




}
