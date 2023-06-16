package com.ifma.lpweb.domain.repository;

import com.ifma.lpweb.domain.model.Jogador;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jogadorRepository")
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
}
