package com.ifma.lpweb.API.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstadioRequest {
    private String nome;
    private String endereco;
    private Integer idTime;
}
