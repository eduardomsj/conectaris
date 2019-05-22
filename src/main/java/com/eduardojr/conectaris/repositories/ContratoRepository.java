package com.eduardojr.conectaris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardojr.conectaris.domain.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

}
