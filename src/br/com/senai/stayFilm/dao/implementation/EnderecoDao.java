package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Endereco;
import br.com.senai.stayFilm.model.Resposta;

@Repository
public class EnderecoDao implements GenericDao<Endereco> {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public void inclui(Endereco obj) throws SQLException {
		// TODO Auto-generated method stub

	}


	@Override
	public Endereco altera(Endereco obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exclui(Long idObj) throws SQLException {
		// TODO Auto-generated method stub

	}


	@Override
	public Endereco pesquisa(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public Endereco pesquisa(long idObj) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
