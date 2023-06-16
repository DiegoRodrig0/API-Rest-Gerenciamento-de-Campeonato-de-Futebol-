package com.ifma.lpweb.API.dto.response;

import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TimeTabelaResponse {
    private Integer id;
    private String nome;

    private Integer SaldoGols;
    private Integer Vitorias;

    public TimeTabelaResponse(){

    }
}
