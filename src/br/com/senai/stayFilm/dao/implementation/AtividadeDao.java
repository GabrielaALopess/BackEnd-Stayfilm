package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Atividade;
import br.com.senai.stayFilm.model.Endereco;
import br.com.senai.stayFilm.model.Resposta;

@Repository
public class AtividadeDao implements GenericDao<Atividade> {

	@PersistenceContext
	private EntityManager manager;

	@Transactional

	@Override
	public void inclui(Atividade avaliacao) throws SQLException {
		manager.persist(avaliacao);
	}



	@Transactional
	@Override
	public Atividade altera(Atividade atividade) throws SQLException {
		return manager.merge(atividade);
	}

	@Transactional
	@Override
	public void exclui(Long idObj) throws SQLException {
		Atividade atividade= manager.find(Atividade.class, idObj);
		manager.remove(atividade);

	}



	@Override
	public Atividade pesquisa(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}



	public void inclui(Endereco endereco, Long idColaborador) {
		// TODO Auto-generated method stub
		
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



}
