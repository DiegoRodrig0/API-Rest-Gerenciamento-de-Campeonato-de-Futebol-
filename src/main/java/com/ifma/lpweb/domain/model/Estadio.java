package com.ifma.lpweb.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Estadio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String endereco;

    public Estadio() {
    }

    public Estadio(String nome, String endereco, Time time) {
        this.nome = nome;
        this.endereco = endereco;
        this.time = time;
    }

    @OneToOne
    @JoinColumn(name = "time_id")
    private Time time;

}
