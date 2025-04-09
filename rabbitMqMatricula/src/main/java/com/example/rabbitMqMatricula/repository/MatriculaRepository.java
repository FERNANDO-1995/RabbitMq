package com.example.rabbitMqMatricula.repository;

import com.example.rabbitMqMatricula.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
