package br.com.senai.stayFilm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import br.com.senai.stayFilm.enumeration.TemaFilme;

@Entity
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilme;
	private String descricaoFilme;
	private TemaFilme temaFilme;
	@ManyToMany
	@JoinColumn(name = "avaliacao_id")
	private Avaliacao idAvaliacao;

	public Long getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Long idFilme) {
		this.idFilme = idFilme;
	}

	public String getDescricaoFilme() {
		return descricaoFilme;
	}

	public void setDescricaoFilme(String descricaoFilme) {
		this.descricaoFilme = descricaoFilme;
	}

	public TemaFilme getTemaFilme() {
		return temaFilme;
	}

	public void setTemaFilme(TemaFilme temaFilme) {
		this.temaFilme = temaFilme;
	}

	public Avaliacao getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Avaliacao idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

}
