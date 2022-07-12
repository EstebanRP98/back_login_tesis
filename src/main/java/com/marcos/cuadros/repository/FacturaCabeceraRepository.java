package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.FacturaCabecera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaCabeceraRepository extends JpaRepository<FacturaCabecera, Integer> {
}
