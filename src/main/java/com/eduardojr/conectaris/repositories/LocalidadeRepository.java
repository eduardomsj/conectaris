package com.eduardojr.conectaris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardojr.conectaris.domain.Localidade;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Integer> {

}
