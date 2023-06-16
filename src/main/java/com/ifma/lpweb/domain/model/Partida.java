package com.ifma.lpweb.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "mandante_id")
    private Time mandante;

    @ManyToOne
    @JoinColumn(name = "visitante_id")
    private Time visitante;

    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

    @OneToOne(mappedBy = "partida")
    private Resultado resultado;

    public Partida() {
    }

}
