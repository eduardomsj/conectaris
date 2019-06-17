package com.eduardojr.conectaris.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Lan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String faixa_ips;
	private String mask;
	private String gateway;
	private String dns1;
	private String dns2;
	private String dns3;
	private String descricao;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="localidade_id")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name="chamado_id")
	private Chamado chamado;
	
	public Lan() {
	}

	public Lan(Integer id, String faixa_ips, String mask, String gateway, String dns1, String dns2, String dns3,
			String descricao, Localidade localidade, Chamado chamado) {
		super();
		this.id = id;
		this.faixa_ips = faixa_ips;
		this.mask = mask;
		this.gateway = gateway;
		this.dns1 = dns1;
		this.dns2 = dns2;
		this.dns3 = dns3;
		this.descricao = descricao;
		this.localidade = localidade;
		this.chamado = chamado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFaixa_ips() {
		return faixa_ips;
	}

	public void setFaixa_ips(String faixa_ips) {
		this.faixa_ips = faixa_ips;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getDns1() {
		return dns1;
	}

	public void setDns1(String dns1) {
		this.dns1 = dns1;
	}

	public String getDns2() {
		return dns2;
	}

	public void setDns2(String dns2) {
		this.dns2 = dns2;
	}

	public String getDns3() {
		return dns3;
	}

	public void setDns3(String dns3) {
		this.dns3 = dns3;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Lan other = (Lan) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
