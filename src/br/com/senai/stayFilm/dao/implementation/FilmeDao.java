package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Filme;

@Repository
public class FilmeDao implements GenericDao<Filme> {

	@Override
	public void insert(Filme obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long idObj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Filme update(Filme obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filme search(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithKey(Filme Filme, long idColaborador) {
		// TODO Auto-generated method stub

	}

	@Override
	public Filme updateWithKey(Filme filme, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Filme> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {
		// TODO Auto-generated method stub
		
	}

}
