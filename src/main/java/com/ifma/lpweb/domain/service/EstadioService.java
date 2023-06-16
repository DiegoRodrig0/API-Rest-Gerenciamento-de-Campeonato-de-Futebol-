package com.ifma.lpweb.domain.service;

import com.ifma.lpweb.domain.model.Estadio;
import com.ifma.lpweb.domain.repository.EstadioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstadioService {
    private final EstadioRepository estadioRepository;

    public Estadio salvarEstadio(Estadio estadio) {
        return estadioRepository.save(estadio);
    }

    public List<Estadio> obterTodosEstadios() {
        return estadioRepository.findAll();
    }

    public Optional<Estadio> buscarPor(Integer id) {
        return estadioRepository.findById(id);
    }

    public Estadio atualziar(Integer id, String nome) {
        Optional<Estadio> estadioAtualizado = estadioRepository.findById(id);
        if(estadioAtualizado.isPresent()){
            Estadio estadio = estadioAtualizado.get();
            estadio.setNome(nome);
            return estadioRepository.save(estadio);
        }
        throw new IllegalArgumentException("Estádio não encontrado.");

    }
}
