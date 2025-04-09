package com.example.rabbitMqMatricula.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Table(name = "TB_MATRICULA")
@Entity
public class Matricula {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data=LocalDate.now();
    private Long  aluno_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(Long aluno_id) {
        this.aluno_id = aluno_id;
    }
}
