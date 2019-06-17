package com.eduardojr.conectaris.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eduardojr.conectaris.domain.Localidade;
import com.eduardojr.conectaris.services.LocalidadeService;

@RestController
@RequestMapping(value="/localidades")
public class LocalidadeResource {
	
	@Autowired
	private LocalidadeService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Localidade obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
				
	}

}
