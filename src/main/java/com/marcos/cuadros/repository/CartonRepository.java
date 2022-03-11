package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.Aglomerado;
import com.marcos.cuadros.model.entity.Carton;
import com.marcos.cuadros.model.entity.Molduras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartonRepository extends JpaRepository<Carton, Integer> {


    @Query(value = "select m " +
            "from Carton m ")
    List<Carton> findAllCarton();

    @Query(value = "select * " +
            "from ( " +
            "select a.Id_carton, a.centimetros, a.precio, ABS(:dimension - a.centimetros) as number " +
            "from carton a " +
            "order by number limit 2) ag " +
            "order by ag.centimetros desc limit 1", nativeQuery = true)
    Carton findCartonByCm(Integer dimension);

}
