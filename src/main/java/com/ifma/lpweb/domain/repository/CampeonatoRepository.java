package com.ifma.lpweb.domain.repository;

import com.ifma.lpweb.domain.model.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Provider;

public interface CampeonatoRepository extends JpaRepository<Campeonato, Integer> {
}
