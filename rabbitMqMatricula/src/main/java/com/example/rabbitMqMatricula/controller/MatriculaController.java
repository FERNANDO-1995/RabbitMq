package com.example.rabbitMqMatricula.controller;

import com.example.rabbitMqMatricula.dto.dtoIn.MatriculaForm;
import com.example.rabbitMqMatricula.dto.dtoOut.MatriculaDto;
import com.example.rabbitMqMatricula.service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/matricula")
public class MatriculaController {
    @Autowired
    private MatriculaService service;
    @GetMapping
    public List<MatriculaDto> index(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<MatriculaDto> store(@RequestBody @Valid MatriculaForm f){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarMatricula(f));
    }
}
