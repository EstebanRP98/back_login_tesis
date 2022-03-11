package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.Carton;
import com.marcos.cuadros.model.entity.VidrioN;
import com.marcos.cuadros.model.entity.VidrioSr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VidrioSRRepository extends JpaRepository<VidrioSr, Integer> {

    @Query(value = "select m " +
            "from VidrioSr m ")
    List<VidrioSr> findAllVidrioSr();

    @Query(value = "select * " +
            "from ( " +
            "select a.Id_vidrio_sr, a.centimetros, a.precio, ABS(:dimension - a.centimetros) as number " +
            "from vidrio_sr a " +
            "order by number limit 2) ag " +
            "order by ag.centimetros desc limit 1", nativeQuery = true)
    VidrioSr findVidrioSrByCm(Integer dimension);


}
