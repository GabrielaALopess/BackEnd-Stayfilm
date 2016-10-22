package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Endereco;
import br.com.senai.stayFilm.model.Escala;
import br.com.senai.stayFilm.model.Resposta;

@Repository
public class ColaboradorDao implements GenericDao<Colaborador> {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@Override
	public void inclui(Colaborador colaborador) throws SQLException {
		manager.persist(colaborador);

	}


	@Transactional
	@Override
	public Colaborador altera(Colaborador colaborador) throws SQLException {
		return manager.merge(colaborador);
	}

	@Transactional
	@Override
	public void exclui(Long idObj) throws SQLException {
		Colaborador colaborador = manager.find(Colaborador.class, idObj);
		manager.remove(colaborador);
		
	}


	@Override
	public Colaborador pesquisa(Long idObj) {
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
//	public Colaborador pesquisa(long idObj) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
