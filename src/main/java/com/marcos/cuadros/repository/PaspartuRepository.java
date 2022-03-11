package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.Carton;
import com.marcos.cuadros.model.entity.Molduras;
import com.marcos.cuadros.model.entity.Paspartu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaspartuRepository extends JpaRepository<Paspartu, Integer> {

    @Query(value = "select m " +
            "from Paspartu m ")
    List<Paspartu> findAllPaspartu();

    @Query(value = "select * " +
            "from ( " +
            "select a.Id_paspartu, a.centimetros, a.precio, ABS(:dimension - a.centimetros) as number " +
            "from paspartu a " +
            "order by number limit 2) ag " +
            "order by ag.centimetros desc limit 1", nativeQuery = true)
    Paspartu findPaspartuByCm(Integer dimension);

}
