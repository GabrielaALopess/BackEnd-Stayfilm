package br.com.senai.stayFilm.enumeration;

public enum TipoPermissao {
	
	ADMINISTRADOR("admin"),USUARIO("user");

	
	private String permissao;
	
	 TipoPermissao(String permissao){
	 	this.permissao=permissao;
	}

	public String getPermissao() {
		return permissao;
	}
	 
}
