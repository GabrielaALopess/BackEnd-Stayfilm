package br.com.senai.stayFilm.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.senai.stayFilm.dao.implementation.TelefoneDao;
import br.com.senai.stayFilm.model.Telefone;

public class TelefoneBo {

	private TelefoneDao telefoneDao;

	public TelefoneBo() {
		telefoneDao = new TelefoneDao();
	}

	public void insert(Telefone telefone) throws SQLException {
		telefoneDao.insert(telefone);
	}

	public Telefone search(Long id) {
		return telefoneDao.search(id);
	}

	public Telefone edit(Telefone telefone) throws SQLException {
		if (exist(telefone.getIdTelefone())) {
			return telefoneDao.update(telefone);
		}
		return null;
	}

	public boolean exist(Long id) {
		return search(id) != null;
	}

	public void insertWithKey(Telefone telefone, long idColaborador) {
		telefoneDao.insertWithKey(telefone, idColaborador);
	}
	
	public void updateWithKey(Telefone telefone, long idColaborador) throws SQLException {
		telefoneDao.updateWithKey(telefone, idColaborador);
	}
	
	public List<Telefone> listar(long idColaborador) {
		return telefoneDao.listar(idColaborador);
	}

}
