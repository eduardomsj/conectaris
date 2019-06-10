package com.eduardojr.conectaris.domain.enums;

public enum TipoAtivo {

	COMPUTADOR(1, "Computador"),
	NOTEBOOK(2, "Notebook"),
	SWITCH(3, "Switch"),
	ROTEADOR(4, "Roteador");
	
	private int cod;
	private String descricao;
	
	private TipoAtivo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoAtivo toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoAtivo x : TipoAtivo.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
