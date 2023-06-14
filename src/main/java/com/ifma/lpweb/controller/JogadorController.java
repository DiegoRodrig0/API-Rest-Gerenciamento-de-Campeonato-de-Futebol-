package com.ifma.lpweb.controller;

import com.ifma.lpweb.domain.model.Jogador;
import com.ifma.lpweb.domain.service.JogadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogador")
public class JogadorController {
    private JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping("/criar")
    public ResponseEntity<Jogador> criar(@RequestBody Jogador jogador) {
        jogadorService.salvar(jogador);
        return new ResponseEntity<>(jogador, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Jogador>> listarTodos() {
        List<Jogador> jogadores = new ArrayList<>();
        jogadores = jogadorService.listarTodos();
        return new ResponseEntity<>(jogadores, HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<Jogador>> listarPor(@PathVariable Integer id) {
        Optional<Jogador> jogador = Optional.ofNullable(jogadorService.buscaPor(id));

        if (jogador.isPresent()) {
            return new ResponseEntity<Optional<Jogador>>(jogador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<Jogador> atualizar(@PathVariable Integer id, @RequestBody Jogador jogador) {
        Jogador jogadorExistente = jogadorService.buscaPor(id);

        if (jogadorExistente != null) {
            if (jogador.getNome() != null) {
                jogadorExistente.setNome(jogador.getNome());
            }
            return new ResponseEntity<>(jogadorExistente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
