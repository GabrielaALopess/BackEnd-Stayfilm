package br.com.senai.stayFilm.ViewModel;
import java.util.Date;

import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Curadoria;
import br.com.senai.stayFilm.model.Usuario;

public class CuradoriaViewModel {

	private Colaborador idColaborador;
	private Usuario idUsuario;
	private Date dataCuradoria;

	public Colaborador getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Colaborador idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getDataCuradoria() {
		return dataCuradoria;
	}

	public void setDataCuradoria(Date dataCuradoria) {
		this.dataCuradoria = dataCuradoria;
	}

	public Curadoria toCuradoria() {
		return new Curadoria(getIdColaborador(), getIdUsuario(), getDataCuradoria());
	}
}
