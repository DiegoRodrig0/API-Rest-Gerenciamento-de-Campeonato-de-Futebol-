package com.ifma.lpweb.domain.service;

import com.ifma.lpweb.domain.model.Partida;
import com.ifma.lpweb.domain.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    private final PartidaRepository partidaRepository;

    public PartidaService(@Qualifier("partidaRepository")PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    public Partida salvar(Partida partida) {
        return partidaRepository.save(partida);
    }

    public List<Partida> listarTodos() {
        List<Partida> partidas = partidaRepository.findAll();
        return partidas;
    }

    public void excluir(Integer id) {
        partidaRepository.deleteById(id);
    }

    public Optional<Partida> buscaPor(Integer id) {
        return partidaRepository.findById(id);
    }



}
