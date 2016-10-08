package br.com.senai.stayFilm.dao;

import java.sql.SQLException;
import java.util.List;

public abstract interface GenericDao<T> {

	void inclui(T obj) throws SQLException;

	List<T> pesquisa(T obj) throws SQLException;

	void altera(T obj) throws SQLException;

	void exclui(T obj) throws SQLException;

}
