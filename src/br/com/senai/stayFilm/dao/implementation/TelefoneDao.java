package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Endereco;
import br.com.senai.stayFilm.model.Resposta;
import br.com.senai.stayFilm.model.Telefone;

@Repository
public class TelefoneDao implements GenericDao<Telefone> {

	@PersistenceContext
	private EntityManager manager;
	
	

	@Transactional
	@Override
	public void inclui(Telefone obj) throws SQLException {
		// TODO Auto-generated method stub

	}


	@Transactional
	@Override
	public Telefone altera(Telefone obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Transactional
	@Override
	public void exclui(Long idObj) throws SQLException {
		// TODO Auto-generated method stub

	}


	@Override
	public Telefone pesquisa(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void inclui(Endereco endereco, long idColaborador) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Endereco altera(Endereco endereco, long idColaborador) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}




//	@Override
//	public Telefone pesquisa(long idObj) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
