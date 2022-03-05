package com.marcos.cuadros.repository;

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
}
