package com.ifma.lpweb.API.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstadioResponse {
    private Integer id;
    private String nome;
    private String endereco;

    public EstadioResponse(Integer id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public EstadioResponse() {
    }
}
