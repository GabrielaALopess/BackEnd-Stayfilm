package br.com.senai.stayFilm.enumeration;

public enum StatusAvaliacao {

	APROVADO("Aprovado"), REPROVADO("Reprovado"), MONITORIA("Monidoria");

	private String statusAvaliacao;

	StatusAvaliacao(String statusAvaliacao) {
		this.statusAvaliacao = statusAvaliacao;
	}

	public String getStatusAvaliacao() {
		return statusAvaliacao;
	}

	public void setStatusAvaliacao(String statusAvaliacao) {
		this.statusAvaliacao = statusAvaliacao;
	}
}
