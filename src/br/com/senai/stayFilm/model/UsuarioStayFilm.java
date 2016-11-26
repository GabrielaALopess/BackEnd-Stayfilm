package br.com.senai.stayFilm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Essa classe foi criada em razão do usuario criador do filme, usuario StayFilm
 * @author Equipe StayFilm
 *
 */
@Entity
public class UsuarioStayFilm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuarioStayFilm;
	private String nomeCompleto;

	public Long getIdUsuarioStayFilm() {
		return idUsuarioStayFilm;
	}

	public void setIdUsuarioStayFilm(Long idUsuarioStayFilm) {
		this.idUsuarioStayFilm = idUsuarioStayFilm;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

}
