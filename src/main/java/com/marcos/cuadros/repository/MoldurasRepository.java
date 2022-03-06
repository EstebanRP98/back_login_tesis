package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.Molduras;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MoldurasRepository extends CrudRepository<Molduras, Integer> {

    @Query(value = "select m " +
            "from Molduras m " +
            "order by m.idmoldura desc")
    List<Molduras> findAllMolduras();

    @Query(value = "select m " +
            "from Molduras m " +
            "where m.idmoldura=:idmoldura ")
    Molduras findMolduraById(Integer idmoldura);

    @Query(value = "select m " +
            "from Molduras m " +
            "order by m.idmoldura desc")
    Page<Molduras> findMoldurasPage(Pageable pageable);

    @Query(value = "select c " +
            "from Molduras c " +
            "where upper(c.nombre) like upper(concat('%',:searchParam,'%')) " +
            "order by c.idmoldura asc ")
    List<Molduras> findAllMoldurasBySearchParam(String searchParam);


}
