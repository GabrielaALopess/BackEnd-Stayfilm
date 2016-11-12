package br.com.senai.stayFilm.enumeration;

public enum StatusFilme {

	APROVADO("Aprovado"), REPROVADO("Reprovado"), MONITORIA("Monidoria"), FAVORITO("Favorito");

	private String statusAvaliacao;

	StatusFilme(String statusAvaliacao) {
		this.statusAvaliacao = statusAvaliacao;
	}

	public String getStatusAvaliacao() {
		return statusAvaliacao;
	}

	public void setStatusAvaliacao(String statusAvaliacao) {
		this.statusAvaliacao = statusAvaliacao;
	}
}
