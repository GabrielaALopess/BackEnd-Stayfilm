package br.com.senai.stayFilm.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.senai.stayFilm.enumeration.StatusFilme;
import br.com.senai.stayFilm.enumeration.TemaFilme;

@Entity
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilme;

	private String descricaoFilme;

	@Enumerated(EnumType.STRING)
	private TemaFilme temaFilme;

	@Enumerated(EnumType.STRING)
	private StatusFilme statusFilme;

	@Fetch(FetchMode.SELECT) // para evitar o produto cartesiano.
	@OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Attachment> attachments;

	@Column
	private Date dataCriacao;

	@OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Avaliacao> avaliacoes;


	public Filme() {

	}

	public Filme(String descricaoFilme, TemaFilme temaFilme, StatusFilme statusFilme, Date dataCriacao,
			List<Avaliacao> idAvaliacoes) {
		setDescricaoFilme(descricaoFilme);
		setTemaFilme(temaFilme);

		setStatus(statusFilme);
		setDataCriacao(dataCriacao);
		setAvaliacoes(idAvaliacoes);
	}

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

	public StatusFilme getStatus() {
		return statusFilme;
	}

	public void setStatus(StatusFilme statusFilme) {
		this.statusFilme = statusFilme;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Date setDataCriacao(Date dataCriacao) {
		return this.dataCriacao = isData();
	}

	public List<Avaliacao> getAvaliacao() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	// public LocalDateTime isData(){LocalDateTime now = LocalDateTime.now(); }
	public Date isData() {
		// posso usar LocalDateTime now = LocalDateTime.now();
		Date data = new Date(System.currentTimeMillis());
		return setDataCriacao(data);
	}

//	@JsonProperty("statusReport")
//	public Boolean isAvaliado() {
//		for (Avaliacao avaliacao : avaliacoes) {
//			if (!avaliacao.isStatusReport()) {
//				return false;
//			}
//		}
//		return true;
//	}
}