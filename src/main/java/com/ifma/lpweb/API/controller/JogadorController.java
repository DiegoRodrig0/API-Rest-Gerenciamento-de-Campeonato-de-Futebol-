package com.ifma.lpweb.API.controller;

import com.ifma.lpweb.API.dto.request.JogadorRequest;
import com.ifma.lpweb.API.dto.response.JogadorResponse;
import com.ifma.lpweb.domain.model.Jogador;
import com.ifma.lpweb.domain.service.JogadorService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private final JogadorService jogadorService;
    private ModelMapper modelMapper;

    public JogadorController(JogadorService jogadorService, ModelMapper modelMapper) {
        this.jogadorService = jogadorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/criar")
    public ResponseEntity<Jogador> criar(@RequestBody JogadorRequest jogadorRequest) {
        Jogador jogador = modelMapper.map(jogadorRequest, Jogador.class);
        Jogador jogadorCriado = jogadorService.salvar(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorCriado);
    }

    @GetMapping("/")
    public ResponseEntity<List<JogadorResponse>> listarTodos() {
        List<Jogador> jogadores = jogadorService.listarTodos();
        List<JogadorResponse> jogadoresDTO = jogadores.stream()
                .map(jogador -> modelMapper.map(jogador, JogadorResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(jogadoresDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> listarPor(@PathVariable Integer id) {
        Optional<Jogador> jogador = jogadorService.buscaPor(id);
        return jogador.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<Jogador> atualizar(@PathVariable Integer id, @RequestBody Jogador jogador) {
        Jogador jogadorAtualizado = jogadorService.atualiza(id, jogador);
        if (jogadorAtualizado != null) {
            return ResponseEntity.ok(jogadorAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
