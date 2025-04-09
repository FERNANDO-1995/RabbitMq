package com.example.rabbitMq.service;

import com.example.rabbitMq.dto.dtoIn.AlunoForm;
import com.example.rabbitMq.dto.dtoOut.AlunoDto;
import com.example.rabbitMq.model.Aluno;
import com.example.rabbitMq.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository rep;
    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final String QUEUE_NAME = "matriculaQueue";

    public List<AlunoDto> listarAll (){
        List<Aluno> alunos =rep.findAll();
        return  AlunoDto.converter(alunos);
    }
    // Metodo para enviar uma mensagem para a fila
    @Transactional
    public AlunoDto salvar(AlunoForm f){
    AlunoDto d =new AlunoDto(rep.save(f.alunoMap()));
        // Envia a mensagem (objeto alunoDTO) para a fila chamada "matriculaQueue"
//        amqpTemplate.convertAndSend(QUEUE_NAME, d);
//        System.out.println("Mensagem enviada para a fila: " + d.getNome());
        return d;
    }


    public List<AlunoDto> listar(String nome){
        List<Aluno> aluno = rep.findByNome(nome);
        return AlunoDto.converter(aluno);
    }
}
