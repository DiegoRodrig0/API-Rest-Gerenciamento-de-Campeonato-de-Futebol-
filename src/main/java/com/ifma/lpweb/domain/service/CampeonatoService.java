package com.ifma.lpweb.domain.service;

import com.ifma.lpweb.domain.model.Campeonato;
import com.ifma.lpweb.domain.model.Jogador;
import com.ifma.lpweb.domain.repository.CampeonatoRepository;

import java.util.List;

public class CampeonatoService {

    private CampeonatoRepository campeonatoRepository;
    private GenericService<Campeonato> genericService;

    public CampeonatoService(CampeonatoRepository campeonatoRepository, GenericService<Campeonato> genericService) {
        this.campeonatoRepository = campeonatoRepository;
        this.genericService = genericService;
    }

    public Campeonato salvar(Campeonato campeonato) {
        return this.genericService.salva(campeonato);
    }

    public List<Campeonato> listarTodos() {
        return genericService.todos();
    }

    public void excluir(Integer id) {
        this.genericService.excluirPor(id );
    }

    public Campeonato buscaPor(Integer id) {
        return this.genericService.buscaPor(id);
    }

    public Campeonato atualiza(Integer id, Campeonato campeonato) {
        return this.genericService.atualiza(campeonato, id);
    }


}
