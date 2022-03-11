package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.Carton;
import com.marcos.cuadros.model.entity.Molduras;
import com.marcos.cuadros.model.entity.Terminado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminadoRepository extends JpaRepository<Terminado, Integer> {

    @Query(value = "select m " +
            "from Terminado m ")
    List<Terminado> findAllTerminado();

    @Query(value = "select * " +
            "from ( " +
            "select a.Id_terminado ,a.centimetros, a.precio, ABS(:dimension - a.centimetros) as number " +
            "from terminado a " +
            "order by number limit 2) ag " +
            "order by ag.centimetros desc limit 1", nativeQuery = true)
    Terminado findTerminadoByCm(Integer dimension);

}
