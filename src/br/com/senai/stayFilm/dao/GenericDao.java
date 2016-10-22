package br.com.senai.stayFilm.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.senai.stayFilm.model.Endereco;
import br.com.senai.stayFilm.model.Escala;
import br.com.senai.stayFilm.model.Resposta;

/**
 * 22/10/2016
 * @author Equipe Stayfilm
 * @param <T>
 * Essa classe contém todos os métodos a serem 
 * implementados nas daos
 */
public abstract interface GenericDao<T> {

	void inclui(T obj) throws SQLException;

	void exclui(Long idObj) throws SQLException;

	T altera(T obj) throws SQLException;

	T pesquisa(Long idObj);

	void insertWithKey (Endereco endereco, long idColaborador);

	Endereco altera(Endereco endereco, long idColaborador) throws SQLException;

	

}
