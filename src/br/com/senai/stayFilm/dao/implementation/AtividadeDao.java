package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Atividade;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;

/**
 * 23/10/2016
 * 
 * @author Equipe Stayfilm Classe utilizada para a persistência dos dados do
 *         Atividade.
 */

@Repository
public class AtividadeDao implements GenericDao<Atividade> {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Inserir as atividades do colaborador
	 */
	@Transactional
	@Override
	public void insertWithKey(Atividade atividade, long idColaborador) {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		atividade.setColaborador(colaborador);
		manager.persist(atividade);

	}

	/**
	 * Esse metodo e responsaver por listar todas as atividades de um colaborador
	 */
	@Override
	public List<Atividade> listar(long idColaborador) { 
		return manager.createQuery("select a where a.colaborador.idColaborador = "+  idColaborador).getResultList();
	}	


	/**
	 * Esse metodo e responsavel por preencher os campos de uma determinada atividade 
	 * transicao entre a lista das atividades e a acao de alterar
	 */
	@Override
	public Atividade buscarPorId(Long idAtividade) {
		return manager.find(Atividade.class, idAtividade);
	}

	
	/**
	 * Metodo para editar os dados da atividade do colaborador
	 */
	@Transactional
	@Override
	public Atividade updateWithKey(Atividade atividade, long idColaborador) throws SQLException {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		atividade.setColaborador(colaborador);
		return manager.merge(atividade);
	}
	

	/**
	 * Metodo responsaver por remover atividade de um colaborador
	 */
	@Transactional
	@Override
	public void delete(Long idAtividade) throws SQLException {
		Atividade atividade = manager.find(Atividade.class, idAtividade);
		manager.remove(atividade);

	}

	
	
	
	@Override
	public void insert(Atividade atividade) throws SQLException {
		// NOT USE

	}
	

	@Override
	public Atividade update(Atividade atividade) throws SQLException {
		// NOT USE
		return null;
	}


	/**
	 * Metodo implementado porem nao utilizado
	 */
	@Override
	public Atividade search(Long idAtividade) {
		return manager.find(Atividade.class, idAtividade);
	}


	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {
		// NOT USE
		
	}

	@Override
	public List<Colaborador> listarTodos() {
		//NOT USE
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta, Long filme) {
		// TODO Auto-generated method stub
		
	}

	

}
