package com.ifma.lpweb.domain.repository;

import com.ifma.lpweb.domain.model.Resultado;
import com.ifma.lpweb.domain.model.Time;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("timeRepository")
public interface TimeRepository extends JpaRepository<Time, Integer> {
}
