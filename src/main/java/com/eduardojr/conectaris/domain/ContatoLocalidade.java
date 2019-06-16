package com.eduardojr.conectaris.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContatoLocalidade extends Contato {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="localidade_id")
	private Localidade localidade;
	
	public ContatoLocalidade() {
	}

	public ContatoLocalidade(Integer id, String nome, String observacao, Localidade localidade) {
		super(id, nome, observacao);
		this.localidade = localidade;
	}
	
	
}
