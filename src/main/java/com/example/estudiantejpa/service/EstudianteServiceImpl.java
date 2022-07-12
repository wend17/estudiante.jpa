package com.example.estudiantejpa.service;

import com.example.estudiantejpa.models.dao.IEstudianteRepository;
import com.example.estudiantejpa.models.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl {

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Transactional(readOnly = true)
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Transactional
    public void save(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    @Transactional(readOnly = true)
    public Estudiante findById(Long id) {
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(id);
        if (optionalEstudiante.isPresent()) {
            return optionalEstudiante.get();
        } else {
            return null;
        }
    }
    @Transactional
    public void deleteById(Long id) {
    estudianteRepository.deleteById(id);
    }
}



