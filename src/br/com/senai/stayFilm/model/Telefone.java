package br.com.senai.stayFilm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.senai.stayFilm.enumeration.TipoTelefone;


/**
 * 22/10/2016
 * @author Equipe Stayfilm
 * Classe modelo 
 * para o telefone do colaborador.
 */

@Entity
public class Telefone {
	
	public Telefone(){
		
	}
	
	public Telefone(TipoTelefone tipotelefone, String numero, Colaborador idColaborador){
		setTipoTelefone(tipotelefone);
		setNumero(numero);
		setIdColaborador(idColaborador);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefone;
	
	private TipoTelefone tipoTelefone;
	private String numero;

	@OneToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador idColaborador;

	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

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
