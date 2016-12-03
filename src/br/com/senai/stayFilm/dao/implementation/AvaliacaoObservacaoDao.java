package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.AvaliacaoObservacao;
import br.com.senai.stayFilm.model.Colaborador;

public class AvaliacaoObservacaoDao implements GenericDao<AvaliacaoObservacao>{
	
	private EntityManager manager;
	
	@Transactional
	public void insert(AvaliacaoObservacao avaliacaoObservacao, Long idAvaliacao) throws SQLException {
		Avaliacao avaliacao = manager.find(Avaliacao.class, idAvaliacao);
		avaliacaoObservacao.setAvaliacao(avaliacao);
		manager.persist(avaliacaoObservacao);
	}

	@Override
	public void delete(Long idObj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AvaliacaoObservacao update(AvaliacaoObservacao obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvaliacaoObservacao search(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithKey(AvaliacaoObservacao obj, long idObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AvaliacaoObservacao updateWithKey(AvaliacaoObservacao obj, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvaliacaoObservacao> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta, Long filme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Colaborador> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvaliacaoObservacao buscarPorId(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(AvaliacaoObservacao obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
