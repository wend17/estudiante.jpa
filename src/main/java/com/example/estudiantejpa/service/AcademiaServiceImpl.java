package com.example.estudiantejpa.service;

import com.example.estudiantejpa.models.dao.IAcademiaRepository;
import com.example.estudiantejpa.models.entity.Academia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AcademiaServiceImpl {

    @Autowired
    private IAcademiaRepository academiaRepository;

    @Transactional(readOnly = true)
    public List<Academia> findAll(){
        return academiaRepository.findAll();
    }


}
