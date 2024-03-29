package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.Carton;
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

    @Query(value = "select * " +
            "from ( " +
            "select a.id_corte, a.centimetros, a.precio, ABS(:dimension - a.centimetros) as number " +
            "from corte a " +
            "order by number limit 2) ag " +
            "order by ag.centimetros desc limit 1", nativeQuery = true)
    Corte findCorteByCm(Integer dimension);

}
