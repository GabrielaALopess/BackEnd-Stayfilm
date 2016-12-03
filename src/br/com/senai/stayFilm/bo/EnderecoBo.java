package br.com.senai.stayFilm.bo;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Endereco;

@Component
public class EnderecoBo {

	
	@Autowired
	@Qualifier("enderecoDao")
	private GenericDao<Endereco> enderecoDao;
	
	
	/**
	 * Metodo responsavel por inserir o endereco do colaborador
	 * @param endereco
	 * @param idColaborador
	 * @throws SQLException
	 */
	public void insert(Endereco endereco, Long idColaborador) throws SQLException {
		enderecoDao.insertWithKey(endereco, idColaborador);
	}
	
	
	/**
	 * Metodo responsavel por preencher os campos do endereco para fazer a alteracao dos dados
	 * @param idEndereco
	 * @return
	 * @throws SQLException
	 */
	public Endereco buscarPorId(Long idEndereco) throws SQLException {
		return enderecoDao.buscarPorId(idEndereco);
	}
	
	/**
	 * Metodo utilizado para alterar os dados de endereco do colaborador
	 * @param endereco
	 * @param idColaborador
	 * @return
	 * @throws SQLException
	 */
	public Endereco edit(Endereco endereco, Long idColaborador) throws SQLException {
		return enderecoDao.updateWithKey(endereco, idColaborador);
}
}
