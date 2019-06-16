package com.eduardojr.conectaris;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eduardojr.conectaris.domain.Ativo;
import com.eduardojr.conectaris.domain.Chamado;
import com.eduardojr.conectaris.domain.Contato;
import com.eduardojr.conectaris.domain.Contrato;
import com.eduardojr.conectaris.domain.Estado;
import com.eduardojr.conectaris.domain.Lan;
import com.eduardojr.conectaris.domain.Link;
import com.eduardojr.conectaris.domain.Localidade;
import com.eduardojr.conectaris.domain.Municipio;
import com.eduardojr.conectaris.domain.Provedor;
import com.eduardojr.conectaris.domain.enums.TipoAtivo;
import com.eduardojr.conectaris.domain.enums.TipoChamado;
import com.eduardojr.conectaris.domain.enums.TipoLink;
import com.eduardojr.conectaris.domain.enums.TipoLocalidade;
import com.eduardojr.conectaris.repositories.AtivoRepository;
import com.eduardojr.conectaris.repositories.ChamadoRepository;
import com.eduardojr.conectaris.repositories.ContatoRepository;
import com.eduardojr.conectaris.repositories.ContratoRepository;
import com.eduardojr.conectaris.repositories.EstadoRepository;
import com.eduardojr.conectaris.repositories.LanRepository;
import com.eduardojr.conectaris.repositories.LinkRepository;
import com.eduardojr.conectaris.repositories.LocalidadeRepository;
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
	@Autowired
	private ContratoRepository contratoRepository;
	@Autowired
	private LinkRepository linkRepository;
	@Autowired
	private AtivoRepository ativoRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private LocalidadeRepository localidadeRepository;
	@Autowired
	private LanRepository lanRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ConectarisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Estado est1 = new Estado(null, "Ceará", null);
		Municipio mun1 = new Municipio(null, "Fortaleza", null, est1);
		Municipio mun2 = new Municipio(null, "Jaguaribe", null, est1);
		
		est1.getMunicipios().addAll(Arrays.asList(mun1, mun2));
		
		Provedor p1 = new Provedor(null, "Brisanet", 123456, null);
		
		Contrato cont1 = new Contrato(null, "16/2019/EJR", "2 HORAS", "Contrato entre Brisanet e EJR", null, p1);
		Contrato cont2 = new Contrato(null, "035/2019/EJR", "3 HORAS", "Contrato2 entre Brisanet e EJR", null, p1);
		
		Localidade l1 = new Localidade(null, "Promotoria de Jaguaribe", TipoLocalidade.PROMOTORIA_INICIAL, null, mun2);
		Localidade l2 = new Localidade(null, "Promotoria de Fortaleza", TipoLocalidade.PROMOTORIA_FINAL, null, mun1);
		
		mun1.getLocalidades().addAll(Arrays.asList(l2));
		mun2.getLocalidades().addAll(Arrays.asList(l1));
		
		Ativo a1 = new Ativo(null, "PC EJR", "123456", "PGJ123", TipoAtivo.COMPUTADOR, l1, null);
		Ativo a2 = new Ativo(null, "Laptop EJR", "123457", "PGJ124", TipoAtivo.NOTEBOOK, l1, null);
		l1.getAtivos().addAll(Arrays.asList(a1, a2));

		Lan lan1 = new Lan(null, "192.168.0.0", "255.255.255.0", "192.168.0.1", "10.1.1.1", "10.1.1.2", null, "LAN Principal", l2, null);
		l2.getLans().addAll(Arrays.asList(lan1));
		
		Link link1 = new Link(null, 1500, "10 Mbps", "10.200.200.1", TipoLink.INTERNET, "10.200.200.0/24", "10.1.1.1", "10.1.1.2", cont1, p1, l1, null);
		Link link2 = new Link(null, 300, "2 Mbps", "10.2.2.1", TipoLink.DADOS, "10.2.2.0/24", "10.1.1.2", "10.1.1.3", cont2, p1, l2, null);

		Chamado ch1 = new Chamado(null, "Computador reiniciando", "Computador reinicia a cada 10 minutos", TipoChamado.INCIDENTE, l1);
		l1.getChamados().addAll(Arrays.asList(ch1));
		
		Contato c1 = new Contato(null, "Vinicius", null, p1);
		Contato c2 = new Contato(null, "Marcia", null, null);		
		c1.getTelefones().addAll(Arrays.asList("2345678", "96699669"));
			
		p1.getLinks().addAll(Arrays.asList(link1, link2));
		p1.getContratos().addAll(Arrays.asList(cont1, cont2));
			
		estadoRepository.saveAll(Arrays.asList(est1));
		municipioRepository.saveAll(Arrays.asList(mun1, mun2));
		localidadeRepository.saveAll(Arrays.asList(l1, l2));
		ativoRepository.saveAll(Arrays.asList(a1, a2));
		lanRepository.saveAll(Arrays.asList(lan1));
		chamadoRepository.saveAll(Arrays.asList(ch1));
		
		provedorRepository.saveAll(Arrays.asList(p1));
		contratoRepository.saveAll(Arrays.asList(cont1, cont2));
		linkRepository.saveAll(Arrays.asList(link1, link2));
		contatoRepository.saveAll(Arrays.asList(c1, c2));
				
	}

}
