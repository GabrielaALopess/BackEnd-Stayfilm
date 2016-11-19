package br.com.senai.stayFilm.enumeration;

public enum TypeAttachment {

	FOTO("foto"), VIDEO("Video"), FILME("filme");

	private String typeAttachment;

	TypeAttachment(String typeAttachment) {
		this.typeAttachment = typeAttachment;
	}

	public String getTypeAttachment() {
		return typeAttachment;
	}

	public void setTypeAttachment(String typeAttachment) {
		this.typeAttachment = typeAttachment;
	}

}
