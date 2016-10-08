package br.com.senai.stayFilm.enumeration;

public enum Status {

	ATIVO("Ativo"), INATIVO("Inativo");

	private String status;

	Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
