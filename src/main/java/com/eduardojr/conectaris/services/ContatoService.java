package com.eduardojr.conectaris.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardojr.conectaris.domain.Contato;
import com.eduardojr.conectaris.repositories.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repo;
	
	public Contato buscar(Integer id) {
		
		Optional<Contato> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
}
