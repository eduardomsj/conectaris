package com.eduardojr.conectaris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardojr.conectaris.domain.Ativo;

@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Integer> {

}
