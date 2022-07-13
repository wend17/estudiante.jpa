package com.example.estudiantejpa.models.dao;

import com.example.estudiantejpa.models.entity.Academia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAcademiaRepository extends JpaRepository<Academia,Long> {
}
