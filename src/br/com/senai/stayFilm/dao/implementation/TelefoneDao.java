package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Telefone;

@Repository
public class TelefoneDao implements GenericDao<Telefone> {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inclui(Telefone obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Telefone> pesquisa(Telefone obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefone altera(Telefone obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exclui(Long idObj) throws SQLException {
		// TODO Auto-generated method stub

	}

}
