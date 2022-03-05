package com.marcos.cuadros.repository;

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

}
