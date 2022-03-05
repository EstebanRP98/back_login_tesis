package com.marcos.cuadros.repository;

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
}
