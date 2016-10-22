package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Telefone;

@Repository
public class TelefoneDao implements GenericDao<Telefone> {

	@Override
	public void insert(Telefone obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long idObj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Telefone update(Telefone obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefone search(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithKey(Telefone obj, long idColaborador) {
		// TODO Auto-generated method stub

	}

	@Override
	public Telefone updateWithKey(Telefone obj, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
