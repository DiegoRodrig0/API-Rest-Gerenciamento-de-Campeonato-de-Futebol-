package com.ifma.lpweb.domain.repository;

import com.ifma.lpweb.domain.model.Campeonato;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("campeonatoRepository")
public interface CampeonatoRepository extends JpaRepository<Campeonato, Integer> {
    // Você pode adicionar métodos personalizados de consulta, se necessário
}