package com.eduardojr.conectaris.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.eduardojr.conectaris.domain.enums.TipoLink;

@Entity
public class Link implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer custo;
	private String velocidade;
	private String gateway;
	private Integer tipo;
	private String faixa_ips;
	private String dns1;
	private String dns2;
	
	@ManyToOne
	@JoinColumn(name="contrato_id")
	private Contrato contrato;
	
	@ManyToOne
	@JoinColumn(name="provedor_id")
	private Provedor provedor;
	
	public Link() {
		
	}

	public Link(Integer id, Integer custo, String velocidade, String gateway, TipoLink tipo, String faixa_ips, String dns1, String dns2, Contrato contrato,
			Provedor provedor) {
		super();
		this.id = id;
		this.custo = custo;
		this.velocidade = velocidade;
		this.gateway = gateway;
		this.tipo = tipo.getCod();
		this.setFaixa_ips(faixa_ips);
		this.setDns1(dns1);
		this.setDns2(dns2);
		this.contrato = contrato;
		this.provedor = provedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCusto() {
		return custo;
	}

	public void setCusto(Integer custo) {
		this.custo = custo;
	}

	public String getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public TipoLink getTipo() {
		return TipoLink.toEnum(tipo);
	}

	public void setTipo(TipoLink tipo) {
		this.tipo = tipo.getCod();
	}

	public String getFaixa_ips() {
		return faixa_ips;
	}

	public void setFaixa_ips(String faixa_ips) {
		this.faixa_ips = faixa_ips;
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
	
	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Provedor getProvedor() {
		return provedor;
	}

	public void setProvedor(Provedor provedor) {
		this.provedor = provedor;
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
		Link other = (Link) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
