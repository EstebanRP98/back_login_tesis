package com.marcos.cuadros.service;

import com.marcos.cuadros.model.entity.Molduras;
import com.marcos.cuadros.shared.modelDto.CalculoMolduraDto;

public interface CalculoServiceInterface {

    public Double calcular(CalculoMolduraDto calculoMolduraDto);
}
