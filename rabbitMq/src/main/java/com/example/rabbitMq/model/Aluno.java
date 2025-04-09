package com.example.rabbitMq.model;

import com.example.rabbitMq.controller.AlunoController;
import com.example.rabbitMq.dto.dtoIn.AlunoForm;
import com.example.rabbitMq.repository.AlunoRepository;
import com.example.rabbitMq.service.AlunoService;
import jakarta.persistence.*;

@Table(name = "TB_ALUNO")
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
