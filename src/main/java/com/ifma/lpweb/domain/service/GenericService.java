package com.ifma.lpweb.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericService<T> {
    private final JpaRepository<T, Integer> repository;

    GenericService(JpaRepository<T, Integer> repository) {
        this.repository = repository;
    }

    T salva(T entity) {
        return repository.save(entity);
    }

    List<T> todos() {
        return repository.findAll();
    }

    T buscaPor(Integer id) {
        return (T) repository.findById(id);
    }

    public void excluirPor(Integer id) {
        this.repository.deleteById(id );
    }

    T atualiza(T entity, Integer id) {
        T entityDoBanco = this.buscaPor(id );
        BeanUtils.copyProperties(entity, entityDoBanco, "id" );

        return entityDoBanco;
    }
}
