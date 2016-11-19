package br.com.senai.stayFilm.bo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Atividade;

/**
 * BO de Atividades.
 * @author Gabriela Lopes
 *
 */
@Component
public class AtividadeBo {

	@Autowired
	@Qualifier("atividadeDao")
	private GenericDao<Atividade> atividadeDao;

	public void insert(Atividade atividade, Long idColaborador) throws SQLException {
		atividadeDao.insertWithKey(atividade, idColaborador);
	}

	/**
	 * Metodo que lista todas as atividade de um colaborador
	 * @param id
	 * @return
	 */
	public List<Atividade> search(Long id) {
		return atividadeDao.listar(id);
	}

	/**
	 * Metodo usado para alterar as as informacoes de atividade
	 * @param atividade
	 * @param idColaborador
	 * @return
	 * @throws SQLException
	 */
	public Atividade edit(Atividade atividade, Long idColaborador) throws SQLException {
			return atividadeDao.updateWithKey(atividade, idColaborador);
	}

	/**
	 * Metodo utilizado para preencher os campos de atividade
	 * Transicao entre a lista de atividades e a acao de alterar
	 * @param idAtividade
	 * @return
	 * @throws SQLException
	 */
	public Atividade buscarPorId(Long idAtividade) throws SQLException {
		return atividadeDao.buscarPorId(idAtividade);
	}
	

	/**
	 * Metodo responsavel por remover uma atividade de um colaborador 
	 * @param idAtividade
	 * @throws SQLException
	 */
	public void remove(Long idAtividade) throws SQLException {
			atividadeDao.delete(idAtividade);
	}

//	public boolean exist(Long id) {
//		return search(id) != null;
//	}

	
	
	
}
