package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Resposta;

@Repository
public class AvaliacaoDao implements GenericDao<Avaliacao> {

	
	@PersistenceContext
	private EntityManager manager;


	@Transactional
	public void insert(Avaliacao avaliacao, long idColaborador,long idResposta) throws SQLException {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		avaliacao.setColaborador(colaborador);
		Resposta resposta = manager.find(Resposta.class, idResposta);
		avaliacao.setIdResposta(resposta);
		manager.persist(avaliacao);

	}

	
	
	@Override
	public void insert(Avaliacao obj) throws SQLException {
		//NOT USE 

	}

	@Override
	public void delete(Long idObj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Avaliacao update(Avaliacao obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Avaliacao search(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void insertWithKey(Avaliacao obj, long id) {
		//NOT USE

	}
	
//	@Override
//	public void insertWithKey(Avaliacao obj, long idColaborador,long idResposta) {
//		// TODO Auto-generated method stub
//
//	}
//	
	
	@Override
	public Avaliacao updateWithKey(Avaliacao obj, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Avaliacao> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Transactional
	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {

		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		avaliacao.setColaborador(colaborador);
		Resposta resposta = manager.find(Resposta.class, idResposta);
		avaliacao.setIdResposta(resposta);
		manager.persist(avaliacao);

	}

}
