package br.com.senai.stayFilm.ViewModel;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.senai.stayFilm.enumeration.TipoTelefone;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Resposta;
import br.com.senai.stayFilm.model.Telefone;

public class TelefoneViewModel {
	private TipoTelefone tipoTelefone;
	private String numero;
	private Colaborador idColaborador;

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Colaborador getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Colaborador idColaborador) {
		this.idColaborador = idColaborador;
	}
	public Telefone toTelefone(){
		return new Telefone(getTipoTelefone(), getNumero(),getIdColaborador());
	}

}
