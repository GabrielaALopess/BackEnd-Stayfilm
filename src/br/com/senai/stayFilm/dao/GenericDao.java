package br.com.senai.stayFilm.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;

/**
 * 22/10/2016
 * @author Equipe Stayfilm
 * @param <T>
 * Essa classe cont�m todos os m�todos a serem 
 * implementados nas daos
 */
public abstract interface GenericDao<T> {

	void insert(T obj) throws SQLException;

	void delete(Long idObj) throws SQLException;

	T update(T obj) throws SQLException;

	T search(Long idObj);

	void insertWithKey (T obj, long idObj);

	T updateWithKey(T obj, long idObj) throws SQLException;
	
	public List<T> listar(long idObj);

	void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta);

	void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta,Long filme);

	
	List<Colaborador> listarTodos();

	T buscarPorId (Long idObj);
}
