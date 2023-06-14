package com.ifma.lpweb.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer ano;
    private String nome;

    public Campeonato(Integer ano, String nome) {
        this.ano = ano;
        this.nome = nome;
    }
}
