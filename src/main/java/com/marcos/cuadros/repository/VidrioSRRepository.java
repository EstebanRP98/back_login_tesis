package com.marcos.cuadros.repository;

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


}
