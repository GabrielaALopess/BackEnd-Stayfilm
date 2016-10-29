package br.com.senai.stayFilm.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.senai.stayFilm.dao.implementation.FilmeDao;
import br.com.senai.stayFilm.dao.implementation.RespostaDao;
import br.com.senai.stayFilm.model.Filme;
import br.com.senai.stayFilm.model.Resposta;

public class FilmeBo {

	private FilmeDao filmeDao;

	public FilmeBo() {
		filmeDao = new FilmeDao();
	}

	public void insert(Filme filme) throws SQLException {
		filmeDao.insert(filme);
	}

	public Filme search(Long id) {
		return filmeDao.search(id);
	}

	public Filme edit(Filme filme) throws SQLException {
		if (exist(filme.getIdFilme())) {
			return filmeDao.update(filme);
		}
		return null;
	}

	public boolean exist(Long id) {
		return search(id) != null;
	}

	public void insertWithKey(Filme filme, long idColaborador) {
		filmeDao.insertWithKey(filme, idColaborador);

	}

	public void updateWithKey(Filme filme, long idColaborador) throws SQLException {
		filmeDao.updateWithKey(filme, idColaborador);
	}

	public List<Filme> listar(long idColaborador) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
