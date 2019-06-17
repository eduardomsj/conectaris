package com.eduardojr.conectaris.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.eduardojr.conectaris.domain.enums.TipoLocalidade;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Localidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer tipo;
	private String descricao;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="localidade")
	private Endereco endereco;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="municipio_id")
	private Municipio municipio;
	
	@OneToMany(mappedBy="localidade")
	private List<ContatoLocalidade> contatos = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy="localidade")	
	private List<Link> links = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy="localidade")
	private List<Ativo> ativos = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy="localidade")
	private List<Lan> lans = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy="localidade")
	private List<Chamado> chamados = new ArrayList<>();
	
	public Localidade() {
	}

	public Localidade(Integer id, String nome, TipoLocalidade tipo, String descricao, Municipio municipio) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo.getCod();
		this.descricao = descricao;
		this.municipio = municipio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoLocalidade getTipo() {
		return TipoLocalidade.toEnum(tipo);
	}

	public void setTipo(TipoLocalidade tipo) {
		this.tipo = tipo.getCod();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public List<Ativo> getAtivos() {
		return ativos;
	}

	public void setAtivos(List<Ativo> ativos) {
		this.ativos = ativos;
	}

	public List<Lan> getLans() {
		return lans;
	}

	public void setLans(List<Lan> lans) {
		this.lans = lans;
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public List<ContatoLocalidade> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoLocalidade> contatos) {
		this.contatos = contatos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidade other = (Localidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
		
}
