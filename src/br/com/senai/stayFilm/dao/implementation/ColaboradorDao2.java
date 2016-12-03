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

/**
 * 22/10/2016
 * 
 * @author Equipe Stayfilm Classe utilizada para a persistência dos dados do
 *         colaborador.
 */

@Repository
public class ColaboradorDao2 implements GenericDao<Colaborador> {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Salvando os dados do colaborador (step 1)
	 */
	@Transactional
	@Override
	public void insert(Colaborador colaborador) throws SQLException {
		manager.persist(colaborador);
	}

	/**
	 * Deleta um colaborador quando encontra o id Metodo nao executado
	 */
	@Transactional
	@Override
	public void delete(Long idColaborador) throws SQLException {
		Colaborador colaborador = manager.find(Colaborador.class, idColaborador);
		manager.remove(colaborador);
	}


	/**
	 * encontra determinado colaborador , buscando pelo id
	 */
	@Override
	public Colaborador search(Long idColaborador) {
		return manager.find(Colaborador.class, idColaborador);
	}

	/**
	 * Metodo utilizado para atualizar os dados de um determinado colaborador
	 */
	@Transactional
	@Override
	public Colaborador updateWithKey(Colaborador colaborador, long idColaborador) throws SQLException {
		colaborador.setIdColaborador(idColaborador);
		return manager.merge(colaborador);
	}

	@Override
	public List<Colaborador> listar(long idObj) {
		return null;
	}

	/**
	 * Lista todos os colaboradores cadastrados no banco , segundo a
	 * especificacao (nome,email e telefone) por ordem alfabetica
	 * 
	 */
	@Override
	public List<Colaborador> listarTodos() {
		return manager.createQuery("select c.nome, c.email, c.telefoneCelular from Colaborador c order by c.nome")
				.getResultList();
	}

	
	/**
	 * Método utilizado para preencher os dados de um colaborador.
	 * (usado na atualizacao, para ver os dados que serao alterados)
	 */
	@Override
	public Colaborador buscarPorId(Long idColaborador) {
		return manager.find(Colaborador.class, idColaborador);
	}
	
	
	
	
	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {
		// TODO Auto-generated method stub

	}

	
	
	/**
	 * atualiza os dados do colaborador (step 1)
	 */
	@Transactional
	@Override
	public Colaborador update(Colaborador colaborador) throws SQLException {
		//NOT USE
		return null;
	}
	
	/**
	 * Metodo nao implementado na classe colaborador
	 */
	@Override
	public void insertWithKey(Colaborador colaborador, long idColaborador) {
		// NOT USE
	}

	/**
	 * Metodo responsavel por realizar o login
	 */
	public  Colaborador realizaLogin(Colaborador colaborador)throws SQLException{
		System.out.println(colaborador.getEmail());
		System.out.println(colaborador.getSenha());
		TypedQuery<Colaborador>query =
				manager.createQuery("SELECT c FROM Colaborador c WHERE c.email = :email and "
						+"c.senha= :senha",Colaborador.class);
		query.setParameter("email",colaborador.getEmail());
		query.setParameter("senha", colaborador.getSenha());
		try{
			return query.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta, Long filme) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
