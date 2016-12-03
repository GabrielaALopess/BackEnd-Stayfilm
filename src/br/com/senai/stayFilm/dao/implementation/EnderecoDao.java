package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Endereco;

/**
 * 22/10/2016
 * 
 * @author Equipe Stayfilm Classe utilizada para a persistência dos dados do
 *         endereco.
 */
@Repository
public class EnderecoDao implements GenericDao<Endereco> {

	@PersistenceContext
	private EntityManager manager;

	
	/**
	 * Metodo responsavel por inserir o endereco
	 */
	@Transactional
	@Override
	public void insertWithKey(Endereco endereco, long idColaborador) {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		endereco.setIdColaborador(colaborador);
		manager.persist(endereco);

	}

	/**
	 * Metodo responsavel por buscar o endereco conforme o id
	 */
	@Override
	public Endereco buscarPorId(Long idColaborador) {
		Endereco endereco = new Endereco();
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		endereco.setIdColaborador(colaborador);		
		return manager.find(Endereco.class, idColaborador);
	}
	
	
	
	
	@Override
	public void insert(Endereco obj) throws SQLException {
		// NOT USE

	}

	@Transactional
	@Override
	public void delete(Long idEndereco) throws SQLException {
		Endereco endereco = manager.find(Endereco.class, idEndereco);
		manager.remove(endereco);

	}

	@Override
	public Endereco update(Endereco obj) throws SQLException {
		// NOT USE
		return null;
	}

	@Override
	public Endereco search(Long idEndereco) {
		return manager.find(Endereco.class, idEndereco);
	}
	


	public Endereco buscarEnderecoColaborador(long idColaborador) {
		
		TypedQuery<Endereco> query=manager.createQuery("SELECT e FROM Endereco e "

				+ "WHERE e.idColaborador.idColaborador = :idcolaborador",Endereco.class);
		query.setParameter("idcolaborador", idColaborador);
		List<Endereco> lista = query.getResultList();
		if(!lista.isEmpty()){
			return lista.get(0);
		}
		return null;
		
	}



	@Transactional
	@Override
	public Endereco updateWithKey(Endereco endereco, long idColaborador) throws SQLException {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		endereco.setIdColaborador(colaborador);
		return manager.merge(endereco);
	}

	@Override
	public List<Endereco> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Colaborador> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta, Long filme) {
		// TODO Auto-generated method stub
		
	}

	

}
