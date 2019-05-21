package com.eduardojr.conectaris;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eduardojr.conectaris.domain.Contato;
import com.eduardojr.conectaris.domain.Estado;
import com.eduardojr.conectaris.domain.Municipio;
import com.eduardojr.conectaris.domain.Provedor;
import com.eduardojr.conectaris.repositories.ContatoRepository;
import com.eduardojr.conectaris.repositories.EstadoRepository;
import com.eduardojr.conectaris.repositories.MunicipioRepository;
import com.eduardojr.conectaris.repositories.ProvedorRepository;

@SpringBootApplication
public class ConectarisApplication implements CommandLineRunner {

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private ProvedorRepository provedorRepository;

	@Autowired
	private MunicipioRepository municipioRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(ConectarisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Provedor p1 = new Provedor(null, "Brisanet", 123456, null);
		
		Contato c1 = new Contato(null, "Vinicius", null, p1);
		Contato c2 = new Contato(null, "Marcia", null, null);
				
		p1.getContatos().addAll(Arrays.asList(c1));
		
		Estado est1 = new Estado(null, "Ceará", null);
		Municipio mun1 = new Municipio(null, "Fortaleza", null, est1);
		
		est1.getMunicipios().addAll(Arrays.asList(mun1));
				
		estadoRepository.saveAll(Arrays.asList(est1));
		municipioRepository.saveAll(Arrays.asList(mun1));
		
		provedorRepository.saveAll(Arrays.asList(p1));
		contatoRepository.saveAll(Arrays.asList(c1, c2));
				
	}

}
