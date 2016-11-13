package br.com.senai.stayFilm.bo;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Colaborador;

/**
 * Bo de Colaborador
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
	 * @param colaborador
	 * @throws SQLException
	 */
	public void insert(Colaborador colaborador) throws SQLException{
		colaboradorDao.insert(colaborador);
	}
	
	public Colaborador buscar(Long id) throws SQLException {
		return colaboradorDao.search(id);
	}
}
