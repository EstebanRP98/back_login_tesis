package com.marcos.cuadros.service;

import com.marcos.cuadros.model.entity.Molduras;
import com.marcos.cuadros.shared.modelDto.PostDto;

import java.util.List;

public interface MolduraServiceInterface {

    public List<Molduras> getMolduras();

    public Molduras getMoldurasById(Integer idMolduras);

    public Molduras updateMolduras(Molduras molduras);

    public List<Molduras> getAllMoldurasPage(Integer pageNo, Integer pageSize, String searchParam);

}
