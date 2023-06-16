package com.ifma.lpweb.domain.service;

import com.ifma.lpweb.domain.model.Time;
import com.ifma.lpweb.domain.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TimeService {
    private final TimeRepository timeRepository;

    public TimeService(@Qualifier("timeRepository")TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public Time salvar(Time time) {
        return timeRepository.save(time);
    }

    public List<Time> listarTodos() {
        List<Time> times = timeRepository.findAll();
        return times;
    }

    public void excluir(Integer id) {
        timeRepository.deleteById(id);
    }

    public Optional<Time> buscaPor(Integer id) {
        return timeRepository.findById(id);
    }

    public Time obterTimePorId(Integer id) {
        return timeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Time não encontrado com o ID"));
    }

}
