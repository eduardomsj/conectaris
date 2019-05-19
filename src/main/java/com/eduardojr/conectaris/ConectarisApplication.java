package com.eduardojr.conectaris;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eduardojr.conectaris.domain.Contato;
import com.eduardojr.conectaris.repositories.ContatoRepository;

@SpringBootApplication
public class ConectarisApplication implements CommandLineRunner {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ConectarisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Contato c1 = new Contato(null, "Vinicius", null);
		Contato c2 = new Contato(null, "Marcia", null);
		
		contatoRepository.saveAll(Arrays.asList(c1, c2));
	}

}
