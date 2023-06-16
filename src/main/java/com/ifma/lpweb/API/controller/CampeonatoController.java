package com.ifma.lpweb.API.controller;

import com.ifma.lpweb.domain.model.Campeonato;
import com.ifma.lpweb.domain.service.CampeonatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    private CampeonatoService campeonatoService;

    public CampeonatoController(CampeonatoService campeonatoService) {
        this.campeonatoService = campeonatoService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Campeonato>> listarTodos() {
        List<Campeonato> campeonatos = new ArrayList<>();
        campeonatos = campeonatoService.listarTodos();
        return new ResponseEntity<>(campeonatos, HttpStatus.OK);
    }
}
