package br.com.senai.stayFilm.bo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.dao.implementation.ColaboradorDao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.viewModel.ColaboradorListaViewModel;

/**
 * Bo de Colaborador
 * 
 * @author Equipe StayFilm
 *
 */

@Component
public class ColaboradorBo {

	@Autowired
	@Qualifier("colaboradorDao")
	private GenericDao<Colaborador> colaboradorDao;

	/**
	 * Método para inserir um colaborador
	 * 
	 * @param colaborador
	 * @throws SQLException
	 */
	public void insert(Colaborador colaborador) throws SQLException {
		colaboradorDao.insert(colaborador);
	}

	public Colaborador buscar(Long id) throws SQLException {
		return colaboradorDao.search(id);
	}

	/**
	 * Lista todos os colaboradores, segundo parametros
	 * 
	 * @return
	 */
	public List<Colaborador> listarTodos() {
		return colaboradorDao.listarTodos();
	}

	
	
	/**
	 * Atualizar os  dados do colaborador quando o mesmo e selecionado
	 * @param colaborador
	 * @param idColaborador
	 * @throws SQLException
	 */
	public Colaborador atualizar(Colaborador colaborador, Long idColaborador) throws SQLException {
		if(colaborador.getSenha()==null || colaborador.getSenha().isEmpty()){
		Colaborador colaboradorbusca = colaboradorDao.buscarPorId(idColaborador);
		colaborador.setSenha(colaboradorbusca.getSenha());
		}
		return colaboradorDao.updateWithKey(colaborador, idColaborador);
	}
	
	
	/**
	 * Metodo usado para preencher os dados dos colaboradores 
	 * (utilizado  na transicao entre a lista e o alterar)
	 * @param idColaborador
	 * @return
	 * @throws SQLException
	 */
	public Colaborador buscarPorId(Long idColaborador) throws SQLException {
		return colaboradorDao.buscarPorId(idColaborador);
	}
	
	
	public Colaborador realizaLogin(Colaborador colaborador) throws SQLException{
			return ((ColaboradorDao) colaboradorDao).realizaLogin(colaborador);
	}
	
}
