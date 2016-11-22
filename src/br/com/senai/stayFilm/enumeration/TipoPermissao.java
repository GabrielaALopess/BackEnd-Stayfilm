package br.com.senai.stayFilm.enumeration;

public enum TipoPermissao {
	

	USUARIO(0),
	ADMINISTRADOR(1);
	
	private int permissao;
//	private List<String> urisAcessiveis;
	
	 TipoPermissao(int permissao){
	 	this.permissao=permissao;
	}

	public int getPermissao() {
		return permissao;
	}
	
//	public boolean possuiPermissao(String uri) {
//		return this.urisAcessiveis.contains(uri);
//	}
	
	
}
