package br.com.senai.stayFilm.enumeration;

public enum TipoPermissao {
	
	ADMINISTRADOR("2"),USUARIO("1");

	
	private String permissao;
	
	 TipoPermissao(String permissao){
	 	this.permissao=permissao;
	}

	public String getPermissao() {
		return permissao;
	}
	 
}
