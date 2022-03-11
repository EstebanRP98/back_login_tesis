package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.Aglomerado;
import com.marcos.cuadros.model.entity.Molduras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AglomeradoRepository extends JpaRepository<Aglomerado, Integer> {

    @Query(value = "select m " +
            "from Aglomerado m ")
    List<Aglomerado> findAllAglomerado();

    @Query(value = "select * " +
            "from ( " +
            "select a.Id_aglomerado, a.centimetros, a.precio, ABS(:dimension - a.centimetros) as number " +
            "from aglomerado a " +
            "order by number limit 2) ag " +
            "order by ag.centimetros desc limit 1", nativeQuery = true)
    Aglomerado findAglomeradoByCm(Integer dimension);

}
