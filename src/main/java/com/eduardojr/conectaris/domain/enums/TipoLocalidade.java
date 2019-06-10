package com.eduardojr.conectaris.domain.enums;

public enum TipoLocalidade {

	PROMOTORIA_FINAL(1, "Promotoria de Entrância Final"),
	PROMOTORIA_INTERMED(2, "Promotoria de Entrância Intermediária"),
	PROMOTORIA_INICIAL(3, "Promotoria de Entrância Inicial"),
	PROMOTORIA_VINCULADA(4, "Promotoria Vinculada"),
	SEDE(5,"Sede PGJ"),
	NUCLEO(6,"Núcleo de Mediação");
	
	private int cod;
	private String descricao;
	
	private TipoLocalidade(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoLocalidade toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoLocalidade x : TipoLocalidade.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
