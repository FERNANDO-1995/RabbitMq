package com.example.rabbitMqMatricula.dto.dtoOut;

import com.example.rabbitMqMatricula.model.Matricula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDto {
    private Long id;
    private LocalDate data=LocalDate.now();

    public MatriculaDto(Matricula m) {
        this.id=m.getId();
        this.data=getData();
    }


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

    public static List<MatriculaDto> converter(List<Matricula> matriculas){
        List<MatriculaDto> dto = new ArrayList<>();
        for(Matricula m: matriculas){
            dto.add(new MatriculaDto(m));
        }
        return dto;
    }
}
