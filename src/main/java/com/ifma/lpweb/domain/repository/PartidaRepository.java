package com.ifma.lpweb.domain.repository;

import com.ifma.lpweb.domain.model.Partida;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("partidaRepository")
public interface PartidaRepository extends JpaRepository<Partida, Integer> {
}
