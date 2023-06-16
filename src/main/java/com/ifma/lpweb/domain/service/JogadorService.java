package com.ifma.lpweb.domain.service;

import com.ifma.lpweb.API.dto.response.JogadorResponse;
import com.ifma.lpweb.domain.model.Jogador;
import com.ifma.lpweb.domain.repository.JogadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {
    private final JogadorRepository jogadorRepository;

    public JogadorService(@Qualifier("jogadorRepository")JogadorRepository jogadorRepository, ModelMapper modelMapper) {
        this.jogadorRepository = jogadorRepository;
    }

    public Jogador salvar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> listarTodos() {
        List<Jogador> jogadores = jogadorRepository.findAll();
        return jogadores;
    }

    public void excluir(Integer id) {
        jogadorRepository.deleteById(id);
    }

    public Optional<Jogador> buscaPor(Integer id) {
        return jogadorRepository.findById(id);
    }

    public Jogador atualiza(Integer id, Jogador jogador) {
        Optional<Jogador> optionalJogadorDoBanco = jogadorRepository.findById(id);
        if (optionalJogadorDoBanco.isPresent()) {
            Jogador jogadorDoBanco = optionalJogadorDoBanco.get();
            jogadorDoBanco.setNome(jogador.getNome());
            jogadorDoBanco.setAltura(jogador.getAltura());
            jogadorDoBanco.setDataNascimento(jogador.getDataNascimento());
            jogadorDoBanco.setGenero(jogador.getGenero());
            jogadorDoBanco.setTime(jogador.getTime());
            return jogadorRepository.save(jogadorDoBanco);
        } else {
            throw new IllegalArgumentException("Jogador não encontrado.");
        }
    }
}
