package com.ifma.lpweb.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    public Time() {
    }

    public Time(String nome) {
        this.nome = nome;
    }

    @OneToMany(mappedBy = "time")
    private List<Jogador> jogadores = new ArrayList<>();

    @OneToOne(mappedBy = "time")
    private Estadio estadio;

    @OneToMany(mappedBy = "mandante")
    private List<Partida> partidasMandante = new ArrayList<>();

    @OneToMany(mappedBy = "visitante")
    private List<Partida> partidasVisitante = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

}
