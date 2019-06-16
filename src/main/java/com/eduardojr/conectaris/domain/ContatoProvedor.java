package com.eduardojr.conectaris.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContatoProvedor extends Contato {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="provedor_id")
	private Provedor provedor;
	
	public ContatoProvedor() {
	}

	public ContatoProvedor(Integer id, String nome, String observacao, Provedor provedor) {
		super(id, nome, observacao);
		this.provedor = provedor;
	}
	
	
}
