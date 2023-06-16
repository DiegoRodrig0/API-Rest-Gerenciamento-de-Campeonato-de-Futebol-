package com.ifma.lpweb.domain.service;

import com.ifma.lpweb.domain.model.Resultado;
import com.ifma.lpweb.domain.repository.ResultadoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoService {

    private final ResultadoRepository resultadoRepository;

    public ResultadoService(@Qualifier("resultadoRepository")ResultadoRepository resultadoRepository) {
        this.resultadoRepository = resultadoRepository;
    }

    public Resultado salvar(Resultado resultado) {
        return resultadoRepository.save(resultado);
    }

    public List<Resultado> listarTodos() {
        List<Resultado> resultados = resultadoRepository.findAll();
        return resultados;
    }

    public void excluir(Integer id) {
        resultadoRepository.deleteById(id);
    }

    public Optional<Resultado> buscaPor(Integer id) {
        return resultadoRepository.findById(id);
    }


}
