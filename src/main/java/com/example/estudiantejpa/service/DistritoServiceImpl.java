package com.example.estudiantejpa.service;

import com.example.estudiantejpa.models.dao.IDistritoRespository;
import com.example.estudiantejpa.models.entity.Distrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistritoServiceImpl {

    @Autowired
    private IDistritoRespository distritoRespository;

    @Transactional(readOnly = true)
    public List<Distrito> findAll(){
        return distritoRespository.findAll();
    }


}
