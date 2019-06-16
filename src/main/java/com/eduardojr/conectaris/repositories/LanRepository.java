package com.eduardojr.conectaris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardojr.conectaris.domain.Lan;

@Repository
public interface LanRepository extends JpaRepository<Lan, Integer> {

}
