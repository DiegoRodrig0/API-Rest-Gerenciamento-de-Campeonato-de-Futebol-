package com.ifma.lpweb.domain.repository;

import com.ifma.lpweb.domain.model.Resultado;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("resultadoRepository")
public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {
}
