package com.marcos.cuadros.service;

import com.marcos.cuadros.model.entity.*;
import com.marcos.cuadros.repository.*;
import com.marcos.cuadros.shared.modelDto.CalculoMolduraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculoService implements CalculoServiceInterface{

    @Autowired
    AglomeradoRepository aglomeradoRepository;

    @Autowired
    CartonRepository cartonRepository;

    @Autowired
    CorteRepository corteRepository;

    @Autowired
    PaspartuRepository paspartuRepository;

    @Autowired
    TerminadoRepository terminadoRepository;

    @Autowired
    VidrioNRepository vidrioNRepository;

    @Autowired
    VidrioSRRepository vidrioSRRepository;

    @Autowired
    MoldurasRepository moldurasRepository;


    @Override
    public Double calcular(CalculoMolduraDto calculoMolduraDto) {
        try {
            Double dimension = (calculoMolduraDto.getMedida1() * 2) + (calculoMolduraDto.getMedida2() * 2);
            Integer valor = new BigDecimal(Math.ceil(dimension)).intValue();
            Double precio = 0.0;

            Corte corteInfo = corteRepository.findCorteByCm(valor);
            Terminado terminadoInfo = terminadoRepository.findTerminadoByCm(valor);
            precio = precio + corteInfo.getPrecio() + terminadoInfo.getPrecio();

            if (calculoMolduraDto.getAglomerado()) {
                Aglomerado aglomeradoInfo = aglomeradoRepository.findAglomeradoByCm(valor);
                precio = precio + (aglomeradoInfo.getPrecio() * calculoMolduraDto.getCantidadAglomerado());
            }
            if (calculoMolduraDto.getPaspartu()) {
                Paspartu paspartuInfo = paspartuRepository.findPaspartuByCm(valor);
                precio = precio + (paspartuInfo.getPrecio() * calculoMolduraDto.getCantidadPaspartu());
            }
            if (calculoMolduraDto.getCarton()) {
                Carton cartonInfo = cartonRepository.findCartonByCm(valor);
                precio = precio + (cartonInfo.getPrecio() * calculoMolduraDto.getCantidadCarton());
            }
            if (calculoMolduraDto.getVidrioN()) {
                VidrioN vidrioNInfo = vidrioNRepository.findVidrioNByCm(valor);
                precio = precio + (vidrioNInfo.getPrecio() * calculoMolduraDto.getCantidadVidrioN());
            }
            if (calculoMolduraDto.getVidrioSr()) {
                VidrioSr vidrioSrInfo = vidrioSRRepository.findVidrioSrByCm(valor);
                precio = precio + (vidrioSrInfo.getPrecio() * calculoMolduraDto.getCantidadVidrioSr());
            }

            Molduras molduras = moldurasRepository.findMolduraById(calculoMolduraDto.getIdmoldura());
            if (molduras != null) {
                precio = precio + molduras.getPrecio();
            }

            return precio;
        }catch (Exception e){
            return null;
        }
    }
}
