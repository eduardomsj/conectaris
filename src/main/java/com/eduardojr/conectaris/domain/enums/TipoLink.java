package com.eduardojr.conectaris.domain.enums;

public enum TipoLink {

	INTERNET(1, "Link de Internet"),
	DADOS(2, "Circuito de Dados"),
	WIMAX(3, "WiMax");
	
	private int cod;
	private String descricao;
	
	private TipoLink(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoLink toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoLink x : TipoLink.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
