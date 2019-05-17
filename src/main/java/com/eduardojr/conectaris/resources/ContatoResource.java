package com.eduardojr.conectaris.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eduardojr.conectaris.domain.Contato;

@RestController
@RequestMapping(value="/contatos")
public class ContatoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Contato> listar() {

		Contato c1 = new Contato(1, "Eduardo", "TI");
		Contato c2 = new Contato(1, "Júnior", "RH");
		
		List<Contato> lista = new ArrayList<>();
		lista.add(c1);
		lista.add(c2);
		
		return lista;
	}

}
