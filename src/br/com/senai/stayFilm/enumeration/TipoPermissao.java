package br.com.senai.stayFilm.enumeration;

import java.util.List;

public enum TipoPermissao {
	
	ADMINISTRADOR(1),
	USUARIO(0);

	
	private int permissao;
	private List<String> urisAcessiveis;
	
	 TipoPermissao(int permissao){
	 	this.permissao=permissao;
	}

	public int getPermissao() {
		return permissao;
	}
	
	public boolean possuiPermissao(String uri) {
		return this.urisAcessiveis.contains(uri);
	}
	
	
}
