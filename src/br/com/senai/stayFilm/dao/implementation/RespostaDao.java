package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Resposta;

@Repository
public class RespostaDao implements GenericDao<Resposta> {

	@Override
	public void insert(Resposta obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long idObj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Resposta update(Resposta obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resposta search(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithKey(Resposta obj, long idColaborador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Resposta updateWithKey(Resposta obj, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
