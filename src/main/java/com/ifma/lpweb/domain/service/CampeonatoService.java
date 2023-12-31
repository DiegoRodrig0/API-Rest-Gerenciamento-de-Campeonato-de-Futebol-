package com.ifma.lpweb.domain.service;

import com.ifma.lpweb.API.dto.request.CampeonatoRequest;
import com.ifma.lpweb.domain.model.Campeonato;
import com.ifma.lpweb.domain.model.Time;
import com.ifma.lpweb.domain.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {
    private final CampeonatoRepository campeonatoRepository;

    public CampeonatoService(@Qualifier("campeonatoRepository") CampeonatoRepository campeonatoRepository) {
        this.campeonatoRepository = campeonatoRepository;
    }

    public Campeonato salvar(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public List<Campeonato> listarTodos() {
        return campeonatoRepository.findAll();
    }

    public void excluir(Integer id) {
        campeonatoRepository.deleteById(id);
    }

    public Optional<Campeonato> buscaPor(Integer id) {
        return campeonatoRepository.findById(id);
    }

    public Campeonato atualizar(Integer id, CampeonatoRequest other) {
        Optional<Campeonato> campeonatoAtualizado = campeonatoRepository.findById(id);
        if(campeonatoAtualizado.isPresent()) {
            Campeonato campeonato = campeonatoAtualizado.get();
            campeonato.setNome(other.getNome());
            campeonato.setAno(other.getAno());
            return campeonatoRepository.save(campeonato);
        }
        throw new IllegalArgumentException("Campeonato não encontrado.");
    }
}
