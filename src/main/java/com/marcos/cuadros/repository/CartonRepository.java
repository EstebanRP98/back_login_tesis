package com.marcos.cuadros.repository;

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

}
