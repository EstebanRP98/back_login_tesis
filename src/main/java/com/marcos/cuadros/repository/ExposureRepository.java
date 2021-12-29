package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.ExposureEntity;
import com.marcos.cuadros.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExposureRepository extends CrudRepository<ExposureEntity, Long> {

}
