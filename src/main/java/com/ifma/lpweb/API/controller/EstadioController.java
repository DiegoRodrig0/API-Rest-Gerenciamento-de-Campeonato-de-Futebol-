package com.ifma.lpweb.API.controller;

import com.ifma.lpweb.API.dto.request.EstadioRequest;
import com.ifma.lpweb.API.dto.request.EstadioUpdateRequest;
import com.ifma.lpweb.API.dto.response.CampeonatoResponse;
import com.ifma.lpweb.API.dto.response.EstadioResponse;
import com.ifma.lpweb.domain.model.Estadio;
import com.ifma.lpweb.domain.model.Time;
import com.ifma.lpweb.domain.service.EstadioService;
import com.ifma.lpweb.domain.service.TimeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estadios")
public class EstadioController {
    private final EstadioService estadioService;
    private final TimeService timeService;
    private ModelMapper modelMapper;

    public EstadioController(EstadioService estadioService, TimeService timeService, ModelMapper modelMapper) {
        this.estadioService = estadioService;
        this.timeService = timeService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/criar")
    public ResponseEntity<EstadioResponse> criar(@RequestBody EstadioRequest estadioRequest) {
        Time time = timeService.obterTimePorId(estadioRequest.getIdTime());
        Estadio estadio = new Estadio(estadioRequest.getNome(), estadioRequest.getEndereco(), time);
        estadioService.salvarEstadio(estadio);
        EstadioResponse estadioResponse = modelMapper.map(estadio, EstadioResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadioResponse);
    }

    @GetMapping("/")
    public ResponseEntity<List<EstadioResponse>> listarTodos() {
        List<Estadio> estadios = estadioService.obterTodosEstadios();
        List<EstadioResponse> estadiosDTO = estadios.stream()
                .map(estadio -> modelMapper.map(estadio, EstadioResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(estadiosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadioResponse> listarPor(@PathVariable Integer id) {
        Optional<Estadio> estadioOptional = estadioService.buscarPor(id);
        if (estadioOptional.isPresent()) {
            Estadio estadio = estadioOptional.get();
            EstadioResponse estadioResponse = modelMapper.map(estadio, EstadioResponse.class);
            return new ResponseEntity<>(estadioResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<EstadioResponse> atualizar(@PathVariable Integer id, @RequestBody EstadioUpdateRequest estadio) {
        Estadio estadioAtualizado = estadioService.atualziar(id,estadio.getNome());
        EstadioResponse estadioResponse = modelMapper.map(estadioAtualizado, EstadioResponse.class);
        return new ResponseEntity<>(estadioResponse, HttpStatus.OK);
    }
}
