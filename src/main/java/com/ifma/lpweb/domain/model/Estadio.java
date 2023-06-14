package com.ifma.lpweb.domain.model;

import jakarta.persistence.*;

@Entity
public class Estadio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String endereco;

    public Estadio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    @OneToOne
    @JoinColumn(name = "time_id")
    private Time time;
}
