package com.ifma.lpweb.API.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CampeonatoResponse {

    private Integer id;
    private Integer ano;
    private String nome;

    public CampeonatoResponse(Integer id, Integer ano, String nome){
        this.id = id;
        this.ano = ano;
        this.nome = nome;
    }
    public CampeonatoResponse(){}
}
