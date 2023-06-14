package com.ifma.lpweb.domain.service;

import com.ifma.lpweb.domain.model.Jogador;
import com.ifma.lpweb.domain.repository.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {
    private JogadorRepository jogadorRepository;
    private GenericService<Jogador> genericService;

    public JogadorService(JogadorRepository jogadorRepository, GenericService<Jogador> genericService) {
        this.jogadorRepository = jogadorRepository;
        this.genericService = genericService;
    }

    public Jogador salvar(Jogador jogador) {
        return this.genericService.salva(jogador);
    }

    public List<Jogador> listarTodos() {
        return genericService.todos();
    }

    public void excluir(Integer id) {
        this.genericService.excluirPor(id );
    }

    public Jogador buscaPor(Integer id) {
        return this.genericService.buscaPor(id);
    }

    public Jogador atualiza(Integer id, Jogador jogador) {
        return this.genericService.atualiza(jogador, id);
    }
}
