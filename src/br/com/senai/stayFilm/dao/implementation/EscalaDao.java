package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Escala;

@Repository
public class EscalaDao implements GenericDao<Escala> {

	@Override
	public void insert(Escala obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long idObj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Escala update(Escala obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Escala search(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithKey(Escala obj, long idColaborador) {
		// TODO Auto-generated method stub

	}

	@Override
	public Escala updateWithKey(Escala obj, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Escala> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

}
