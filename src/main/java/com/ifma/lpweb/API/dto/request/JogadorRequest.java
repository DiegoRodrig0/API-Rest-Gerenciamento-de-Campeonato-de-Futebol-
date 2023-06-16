package com.ifma.lpweb.API.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class JogadorRequest {
    private float altura;
    private LocalDate dataNascimento;
    private String genero;
    private String nome;
    private Long timeId;
}
