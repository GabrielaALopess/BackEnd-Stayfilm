package br.com.senai.stayFilm.enumeration;

public enum TipoTelefone {

	RESIDENCIAL("Residencial"), CELULAR("Celular");

	private String tipoTelefone;

	TipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
}
