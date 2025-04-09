package com.example.rabbitMq.controller;

import com.example.rabbitMq.dto.dtoIn.AlunoForm;
import com.example.rabbitMq.dto.dtoOut.AlunoDto;
import com.example.rabbitMq.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;


    @GetMapping
    public List<AlunoDto> index(){
        return service.listarAll();
    }

    @PostMapping
    public ResponseEntity<AlunoDto> store(@RequestBody @Valid AlunoForm f){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(f));
    }

    @GetMapping("/{nome}")
    public List<AlunoDto> show(@PathVariable String nome){
        return service.listar(nome);
    }
}
