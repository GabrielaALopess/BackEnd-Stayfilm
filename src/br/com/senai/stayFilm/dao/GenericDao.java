package br.com.senai.stayFilm.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.senai.stayFilm.model.Endereco;
import br.com.senai.stayFilm.model.Escala;
import br.com.senai.stayFilm.model.Resposta;

public abstract interface GenericDao<T> {

	void inclui(T obj) throws SQLException;

	void exclui(Long idObj) throws SQLException;

	T altera(T obj) throws SQLException;

	T pesquisa(Long idObj);

	void inclui(Endereco endereco, long idColaborador);

	Endereco altera(Endereco endereco, long idColaborador) throws SQLException;

	

}
