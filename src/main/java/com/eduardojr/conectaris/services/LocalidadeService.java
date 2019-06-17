package com.eduardojr.conectaris.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardojr.conectaris.domain.Localidade;
import com.eduardojr.conectaris.repositories.LocalidadeRepository;
import com.eduardojr.conectaris.services.exceptions.ObjectNotFoundException;

@Service
public class LocalidadeService {

	@Autowired
	private LocalidadeRepository repo;
	
	public Localidade buscar(Integer id) {
		
		Optional<Localidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Localidade.class.getName()));
	}
}
