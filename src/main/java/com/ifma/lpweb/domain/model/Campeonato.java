package com.ifma.lpweb.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer ano;
    private String nome;

    @OneToMany(mappedBy = "campeonato")
    private List<Partida> partidas = new ArrayList<>();

    @OneToMany(mappedBy = "campeonato")
    private List<Time> times = new ArrayList<>();


    public Campeonato() {
    }
}
