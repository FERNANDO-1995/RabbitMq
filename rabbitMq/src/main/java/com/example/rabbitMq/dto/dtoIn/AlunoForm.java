package com.example.rabbitMq.dto.dtoIn;

import com.example.rabbitMq.model.Aluno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AlunoForm {
    @NotBlank
    private String nome;
    @Email
    private String email;

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

    public Aluno alunoMap(){
        Aluno a = new Aluno();
        a.setNome(this.nome);
        a.setEmail(this.email);
        return a;
    }
}
