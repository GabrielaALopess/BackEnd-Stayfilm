package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Endereco;
import br.com.senai.stayFilm.model.Escala;
import br.com.senai.stayFilm.model.Resposta;

@Repository
public class EscalaDao implements GenericDao<Escala> {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@Override
	public void inclui(Escala escala) throws SQLException {
		manager.persist(escala);
	}


	@Override
	public Escala altera(Escala escala) throws SQLException {
		return manager.merge(escala);
	}

	@Transactional
	@Override
	public void exclui(Long idObj) throws SQLException {
		Escala escala = manager.find(Escala.class, idObj);
		manager.remove(escala);
	}


	@Override
	public Escala pesquisa(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Endereco altera(Endereco endereco, long idColaborador) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertWithKey(Endereco endereco, long idColaborador) {
		// TODO Auto-generated method stub
		
	}


//	@Override
//	public Escala pesquisa(long idObj) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
