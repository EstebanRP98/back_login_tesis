package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalle, Integer> {
}
