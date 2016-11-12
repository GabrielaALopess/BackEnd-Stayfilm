package br.com.senai.stayFilm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.senai.stayFilm.enumeration.TypeAttachment;


@Entity
public class Attachment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAttachment;
	@Column
	private String caminhoUri;
	
	@Enumerated(EnumType.STRING)
	private TypeAttachment typeAttachments;
	
	@ManyToOne
	@JoinColumn(name="filme_id")
	private Filme filme;


	
	public Long getIdAttachment() {
		return idAttachment;
	}

	public void setIdAttachment(Long idAttachment) {
		this.idAttachment = idAttachment;
	}

	public String getCaminhoUri() {
		return caminhoUri;
	}

	public void setCaminhoUri(String caminhoUri) {
		this.caminhoUri = caminhoUri;
	}

	public TypeAttachment getTypeAttachments() {
		return typeAttachments;
	}

	public void setTypeAttachments(TypeAttachment typeAttachments) {
		this.typeAttachments = typeAttachments;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	
	

}
