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

            Double dimension = (calculoMolduraDto.getMedida1() * 2) + (calculoMolduraDto.getMedida2() * 2);
            Integer valor = new BigDecimal(Math.ceil(dimension)).intValue();
            Double precio = 0.0;

            Molduras moldurasOne = moldurasRepository.findMolduraById(calculoMolduraDto.getIdmolduraOne());
            if (moldurasOne != null) {
                Double metros=dimension/100;
                precio = precio + (moldurasOne.getPrecio()*metros);
            }
            Molduras moldurasTwo = moldurasRepository.findMolduraById(calculoMolduraDto.getIdmolduraTwo());
            if (moldurasTwo != null) {
                Double metros=dimension/100;
                precio = precio + (moldurasTwo.getPrecio()*metros);
            }
            Molduras moldurasThree = moldurasRepository.findMolduraById(calculoMolduraDto.getIdmolduraThree());
            if (moldurasThree != null) {
                Double metros=dimension/100;
                precio = precio + (moldurasThree.getPrecio()*metros);
            }

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



            //calculo del 24%
            precio = precio +(precio *0.24);

            return Math.ceil(precio);
    }
}
