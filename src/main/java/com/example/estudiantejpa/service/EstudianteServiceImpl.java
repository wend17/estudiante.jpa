package com.example.estudiantejpa.service;

import com.example.estudiantejpa.models.dao.IEstudianteRepository;
import com.example.estudiantejpa.models.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class EstudianteServiceImpl {

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Transactional(readOnly=true)
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }
    @Transactional
    public void save (Estudiante estudiante){
        estudianteRepository.save(estudiante);
    }

}




