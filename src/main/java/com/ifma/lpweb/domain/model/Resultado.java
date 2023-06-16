package com.ifma.lpweb.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numGolsMantande;
    private Integer numGolsVisitante;

    @OneToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;

    public Resultado() {
    }
}
