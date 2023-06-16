package com.ifma.lpweb.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter @Setter
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private String genero;
    private float altura;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

    public Jogador() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return Float.compare(jogador.altura, altura) == 0 && Objects.equals(id, jogador.id) && Objects.equals(nome, jogador.nome) && Objects.equals(dataNascimento, jogador.dataNascimento) && Objects.equals(genero, jogador.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataNascimento, genero, altura);
    }
}