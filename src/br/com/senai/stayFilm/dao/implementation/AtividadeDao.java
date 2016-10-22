package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Atividade;

@Repository
public class AtividadeDao implements GenericDao<Atividade> {

	@Override
	public void insert(Atividade atividade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long idAtividade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Atividade update(Atividade atividade) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Atividade search(Long idAtividade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithKey(Atividade obj, long idObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Atividade updateWithKey(Atividade obj, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

