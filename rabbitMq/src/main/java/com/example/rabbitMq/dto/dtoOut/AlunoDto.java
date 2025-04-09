package com.example.rabbitMq.dto.dtoOut;

import java.util.ArrayList;
import java.util.List;
import com.example.rabbitMq.model.Aluno;

public class AlunoDto {
    private Long id;
    private String nome;
    private String email;

    public AlunoDto(Aluno a) {
        this.id=a.getId();
        this.nome=a.getNome();
        this.email=a.getEmail();
    }

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

    public static List<AlunoDto> converter(List<Aluno> alunos){
        List<AlunoDto> dto = new ArrayList<>();
        for (Aluno a: alunos){
            dto.add(new AlunoDto(a));

        }
        return dto;
    }
}
