package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.Corte;
import com.marcos.cuadros.model.entity.Molduras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorteRepository extends JpaRepository<Corte, Integer> {

    @Query(value = "select m " +
            "from Corte m ")
    List<Corte> findAllCorte();

}
