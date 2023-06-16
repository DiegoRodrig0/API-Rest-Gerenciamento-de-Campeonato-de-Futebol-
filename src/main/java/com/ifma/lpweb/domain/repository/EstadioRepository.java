package com.ifma.lpweb.domain.repository;

import com.ifma.lpweb.domain.model.Estadio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("estadioRepository")
public interface EstadioRepository extends JpaRepository<Estadio, Integer> {
}
