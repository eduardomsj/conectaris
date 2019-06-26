package com.eduardojr.conectaris.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.eduardojr.conectaris.domain.enums.TipoAtivo;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String serial;
	private String patrimonio;
	private Integer tipo;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="localidade_id")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name="chamado_id")
	private Chamado chamado;
	
	public Ativo() {
	}

	public Ativo(Integer id, String descricao, String serial, String patrimonio, TipoAtivo tipo, Localidade localidade, Chamado chamado) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.serial = serial;
		this.patrimonio = patrimonio;
		this.tipo = tipo.getCod();
		this.localidade = localidade;
		this.chamado = chamado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public TipoAtivo getTipo() {
		return TipoAtivo.toEnum(tipo);
	}

	public void setTipo(TipoAtivo tipo) {
		this.tipo = tipo.getCod();
	}
	
	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
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
		Ativo other = (Ativo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
