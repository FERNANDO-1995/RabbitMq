package com.example.rabbitMqMatricula.service;

import com.example.rabbitMqMatricula.dto.dtoIn.MatriculaForm;
import com.example.rabbitMqMatricula.dto.dtoOut.AlunoDto;
import com.example.rabbitMqMatricula.dto.dtoOut.MatriculaDto;
import com.example.rabbitMqMatricula.model.Matricula;
import com.example.rabbitMqMatricula.repository.MatriculaRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository rep;

    public List<MatriculaDto> listar(){
        List<Matricula> matriculas = rep.findAll();
        return MatriculaDto.converter(matriculas);
    }

    @RabbitListener(queues = "matriculaQueue")
    public MatriculaDto salvar(AlunoDto dto) {

        // Acessando e exibindo os dados diretamente
        System.out.println("Aluno matriculado: " + dto.getNome());
        Matricula m = new Matricula();
       // m.setData(f.getData());
        //DEPOIS TENHO DE ALTERAR ESTA CENA
        m.setAluno_id(dto.getId());
        return new MatriculaDto(rep.save(m));
    }

    public MatriculaDto salvarMatricula(MatriculaForm f) {

       Matricula m = new Matricula();
        m.setData(f.getData());
        m.setAluno_id(f.getAluno_id());
        return new MatriculaDto(rep.save(m));
    }
}
