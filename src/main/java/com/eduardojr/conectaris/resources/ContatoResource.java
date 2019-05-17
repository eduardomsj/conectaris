package com.eduardojr.conectaris.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/contatos")
public class ContatoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "REST OK";
	}

}