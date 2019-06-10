package com.eduardojr.conectaris.domain.enums;

public enum TipoChamado {

	INCIDENTE(1, "Incidente"),
	REQUISICAO(2, "Requisição"),
	MUDANCA(3, "Mudança");
	
	private int cod;
	private String descricao;
	
	private TipoChamado(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoChamado toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoChamado x : TipoChamado.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
