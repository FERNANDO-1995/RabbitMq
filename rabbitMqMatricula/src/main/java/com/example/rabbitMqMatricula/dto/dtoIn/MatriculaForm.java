package com.example.rabbitMqMatricula.dto.dtoIn;

import java.time.LocalDate;

public class MatriculaForm {
    private Long id;
    private LocalDate data;
    private Long  aluno_id;

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
