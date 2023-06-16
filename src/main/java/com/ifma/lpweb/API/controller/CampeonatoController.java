package com.ifma.lpweb.API.controller;

import com.ifma.lpweb.API.dto.response.CampeonatoResponse;
import com.ifma.lpweb.API.dto.response.JogadorResponse;
import com.ifma.lpweb.API.dto.response.TimeResponse;
import com.ifma.lpweb.API.dto.response.TimeTabelaResponse;
import com.ifma.lpweb.domain.model.*;
import com.ifma.lpweb.domain.service.CampeonatoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
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

    @GetMapping("/{id}/tabela")
    public ResponseEntity<List<TimeTabelaResponse>> listarTimesPorCampeonato(@PathVariable Integer id) {
        Optional<Campeonato> campeonatoOptional = campeonatoService.buscaPor(id);
        if (campeonatoOptional.isPresent()) {
            Campeonato campeonato = campeonatoOptional.get();
            List<Time> times = campeonato.getTimes();

            for (Time time : times) {
                int vitorias = 0;
                int saldoGols = 0;

                // Calcular as estatísticas com base nos resultados das partidas
                for (Partida partida : time.getPartidasMandante()) {
                    Resultado resultado = partida.getResultado();
                    if (resultado != null) {
                        System.out.println("Tem Resultado");
                        Integer numGolsMandante = resultado.getNumGolsMandante();
                        Integer numGolsVisitante = resultado.getNumGolsVisitante();
                        if (numGolsMandante != null && numGolsVisitante != null) {
                            System.out.println("Tem Gols");
                            if (numGolsMandante > numGolsVisitante) {
                                System.out.println("Venceu");
                                vitorias++;
                            }
                            saldoGols += (numGolsMandante - numGolsVisitante);
                            System.out.println(saldoGols);
                        }
                    }
                }

                for (Partida partida : time.getPartidasVisitante()) {
                    Resultado resultado = partida.getResultado();
                    if (resultado != null) {
                        Integer numGolsMandante = resultado.getNumGolsMandante();
                        Integer numGolsVisitante = resultado.getNumGolsVisitante();
                        if (numGolsMandante != null && numGolsVisitante != null) {
                            if (numGolsVisitante > numGolsMandante) {
                                vitorias++;
                            }
                            saldoGols += (numGolsVisitante - numGolsMandante);
                        }
                    }
                }
                System.out.println(vitorias);
                System.out.println(saldoGols);
                time.setVitorias(vitorias);
                time.setSaldoGols(saldoGols);
            }

            // Ordenar os times pela tabela do campeonato
            times.sort(Comparator.comparing(Time::getVitorias)
                    .thenComparing(Time::getSaldoGols)
                    .reversed());
            List<TimeTabelaResponse> timeDTO = times.stream()
                    .map(time -> modelMapper.map(time, TimeTabelaResponse.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(timeDTO, HttpStatus.OK);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/times")
    public ResponseEntity<List<TimeResponse>> listarTabelaCampeonato(@PathVariable Integer id) {
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
