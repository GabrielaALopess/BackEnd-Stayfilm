package br.com.senai.stayFilm.vizualizacao.viewModel;

import br.com.senai.stayFilm.enumeration.TipoTelefone;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Telefone;

public class TelefoneVizualizacaoViewModel {

	public TelefoneVizualizacaoViewModel(Telefone telefone) {
		setTipoTelefone(telefone.getTipoTelefone());
		setNumero(telefone.getNumero());
		setIdColaborador(telefone.getIdColaborador());
	}

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

}
