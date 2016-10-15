package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Filme;
import br.com.senai.stayFilm.model.Resposta;

@Repository
public class FilmeDao implements GenericDao<Filme> {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inclui(Filme obj) throws SQLException {
		// TODO Auto-generated method stub

	}


	@Override
	public Filme altera(Filme obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exclui(Long idObj) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Filme pesquisa(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public Filme pesquisa(long idObj) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
