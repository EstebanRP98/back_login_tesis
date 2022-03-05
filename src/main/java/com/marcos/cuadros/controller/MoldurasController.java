package com.marcos.cuadros.controller;

import com.marcos.cuadros.model.entity.Molduras;
import com.marcos.cuadros.model.request.PostCreateRequestModel;
import com.marcos.cuadros.model.response.PostRest;
import com.marcos.cuadros.service.MolduraServiceInterface;
import com.marcos.cuadros.shared.modelDto.PostCreationDto;
import com.marcos.cuadros.shared.modelDto.PostDto;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/molduras")
public class MoldurasController {

    @Autowired
    MolduraServiceInterface molduraServiceInterface;

    @GetMapping(path = "/findAllMolduras")
    public List<Molduras> lastsMolduras(){
        List<Molduras> moldurasList = molduraServiceInterface.getMolduras();
        return moldurasList;
    }

    @PostMapping(path = "/createMolduras")
    public Molduras createMolduras(@RequestBody Molduras molduras){
        Molduras moldulaCreada = molduraServiceInterface.updateMolduras(molduras);
        return moldulaCreada;
    }

    @RequestMapping(value = "/findMoldurasById", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Molduras> findMoldurasById(@RequestParam(value = "moldurasId") Integer moldurasId) {
        return new ResponseEntity<>(molduraServiceInterface.getMoldurasById(moldurasId), HttpStatus.OK);
    }

    @GetMapping("/findAllPagination")
    public ResponseEntity<List<Molduras>> getAllFatcaNotification(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(value = "searchParam",required = false) String searchParam)
    {
        List<Molduras> list = molduraServiceInterface.getAllMoldurasPage(pageNo, pageSize,searchParam);
        return new ResponseEntity<List<Molduras>>(list, new HttpHeaders(), HttpStatus.OK);
    }



}
