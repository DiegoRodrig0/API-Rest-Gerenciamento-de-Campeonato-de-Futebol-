package com.ifma.lpweb.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany(mappedBy = "campeonatos")
    private List<Time> times = new ArrayList<>();


    public Campeonato() {
    }

}
