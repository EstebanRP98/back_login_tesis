package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.Carton;
import com.marcos.cuadros.model.entity.Terminado;
import com.marcos.cuadros.model.entity.VidrioN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VidrioNRepository extends JpaRepository<VidrioN, Integer> {

    @Query(value = "select m " +
            "from VidrioN m ")
    List<VidrioN> findAllVidrioN();

    @Query(value = "select * " +
            "from ( " +
            "select a.id_vidrio_n, a.centimetros, a.precio, ABS(:dimension - a.centimetros) as number " +
            "from vidrio_n a " +
            "order by number limit 2) ag " +
            "order by ag.centimetros desc limit 1", nativeQuery = true)
    VidrioN findVidrioNByCm(Integer dimension);

}
