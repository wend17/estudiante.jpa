package com.example.estudiantejpa.models.dao;

import com.example.estudiantejpa.models.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {

}
