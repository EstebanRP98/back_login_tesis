package com.marcos.cuadros.service;

import com.marcos.cuadros.model.entity.Molduras;
import com.marcos.cuadros.model.entity.PostEntity;
import com.marcos.cuadros.repository.MoldurasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MolduraService implements MolduraServiceInterface{

    @Autowired
    MoldurasRepository moldurasRepository;

    @Override
    public List<Molduras> getMolduras() {
        List<Molduras> listMolduras = moldurasRepository.findAllMolduras();
        return listMolduras;
    }

    @Override
    public Molduras getMoldurasById(Integer idMolduras) {
        Molduras molduras = moldurasRepository.findMolduraById(idMolduras);
        return  molduras;
    }

    @Override
    public Molduras updateMolduras(Molduras moldura) {
        Molduras molduraAntigua = moldurasRepository.findMolduraById(moldura.getIdmoldura());
        molduraAntigua.setIdmoldura(moldura.getIdmoldura());
        molduraAntigua.setNombre(moldura.getNombre());
        molduraAntigua.setPrecio(moldura.getPrecio());
        Molduras moldurasGuardada = moldurasRepository.save(molduraAntigua);
        return moldurasGuardada;
    }

    @Override
    public List<Molduras> getAllMoldurasPage(Integer pageNo, Integer pageSize, String searchParam) {

            Pageable paging = PageRequest.of(pageNo, pageSize);
            if(searchParam!=null && searchParam.length()>3){
                return moldurasRepository.findAllMoldurasBySearchParam(searchParam);
            }else{
                Page<Molduras> pagedResult = moldurasRepository.findMoldurasPage(paging);
                if (pagedResult.hasContent()) {
                    return pagedResult.getContent();
                } else {
                    return null;
                }
            }

    }


}
