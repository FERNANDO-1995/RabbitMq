package com.example.rabbitMq.repository;

import com.example.rabbitMq.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNome(String nome);
}
