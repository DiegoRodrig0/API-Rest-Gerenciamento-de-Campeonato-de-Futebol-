package com.ifma.lpweb.API.controller;

import com.ifma.lpweb.API.dto.response.CampeonatoResponse;
import com.ifma.lpweb.API.dto.response.JogadorResponse;
import com.ifma.lpweb.API.dto.response.TimeResponse;
import com.ifma.lpweb.domain.model.Campeonato;
import com.ifma.lpweb.domain.model.Jogador;
import com.ifma.lpweb.domain.model.Time;
import com.ifma.lpweb.domain.service.CampeonatoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    private CampeonatoService campeonatoService;
    private ModelMapper modelMapper;

    public CampeonatoController(CampeonatoService campeonatoService, ModelMapper modelMapper) {
        this.campeonatoService = campeonatoService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/")
    public ResponseEntity<List<CampeonatoResponse>> listarTodos() {
        List<Campeonato> campeonatos = campeonatoService.listarTodos();
        List<CampeonatoResponse> campeonatoDTO = campeonatos.stream()
                .map(campeonato -> modelMapper.map(campeonato, CampeonatoResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(campeonatoDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampeonatoResponse> listarPor(@PathVariable Integer id) {
        Optional<Campeonato> campeonatoOptional  = campeonatoService.buscaPor(id);
        if (campeonatoOptional.isPresent()) {
            Campeonato campeonato = campeonatoOptional.get();
            CampeonatoResponse campeonatoResponse = modelMapper.map(campeonato, CampeonatoResponse.class);
            return ResponseEntity.ok(campeonatoResponse);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/{id}/times")
    public ResponseEntity<List<TimeResponse>> listarTimesPorCampeonato(@PathVariable Integer id) {
        Optional<Campeonato> campeonatoOptional = campeonatoService.buscaPor(id);
        if (campeonatoOptional.isPresent()) {
            Campeonato campeonato = campeonatoOptional.get();
            List<Time> times = campeonato.getTimes();
            List<TimeResponse> timeDTO = times.stream()
                    .map(time -> modelMapper.map(time, TimeResponse.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(timeDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
