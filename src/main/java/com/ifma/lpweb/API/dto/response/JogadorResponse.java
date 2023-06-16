package com.ifma.lpweb.API.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JogadorResponse {
    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    // Outros atributos do jogador, se houver

    // Getters e Setters

    public JogadorResponse(Integer id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public JogadorResponse() {
    }
}
