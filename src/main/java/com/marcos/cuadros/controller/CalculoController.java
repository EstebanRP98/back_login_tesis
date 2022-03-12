package com.marcos.cuadros.controller;

import com.marcos.cuadros.model.entity.Molduras;
import com.marcos.cuadros.service.CalculoServiceInterface;
import com.marcos.cuadros.shared.modelDto.CalculoMolduraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculo")
public class CalculoController {

    @Autowired
    CalculoServiceInterface calculoServiceInterface;

    @RequestMapping(value = "/calcular", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Double> calcular(@RequestBody CalculoMolduraDto calculoMolduraDto) {
        return new ResponseEntity<Double>(calculoServiceInterface.calcular(calculoMolduraDto), HttpStatus.OK);
    }


}
