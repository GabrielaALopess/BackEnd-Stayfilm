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
import br.com.senai.stayFilm.model.Escala;
import br.com.senai.stayFilm.model.EscalaBloqueioEspecifico;
import br.com.senai.stayFilm.vizualizacao.viewModel.EscalaVisualizacaoViewModel;

@Repository
public class EscalaDao implements GenericDao<Escala> {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@Override
	public void insert(Escala escala) throws SQLException {
		manager.persist(escala);
	}

	@Transactional
	@Override
	public void delete(Long idEscala) throws SQLException {
		Escala escala = manager.find(Escala.class, idEscala);
		manager.remove(escala);

	}

	@Override
	public Escala search(Long idEscala) {
		return manager.find(Escala.class, idEscala);
	}

	public List<Escala> listaEscalaGeral() {
		TypedQuery<Escala> query = manager.createQuery("SELECT e FROM  Escala e", Escala.class);
		return query.getResultList();

	}

	public List<Escala> listaEscala(Colaborador colaboradorId, int mes, int ano) {
		String hql = "SELECT e FROM Escala e "
				+ "WHERE month(e.dataEscala) =:mes AND year(e.dataEscala) =:ano AND e.colaborador.idColaborador = :colaborador";
		TypedQuery<Escala> query = manager.createQuery(hql, Escala.class);
		query.setParameter("mes", mes);
		query.setParameter("ano", ano);
		query.setParameter("colaborador", colaboradorId.getIdColaborador());
		List<Escala> escala = query.getResultList();

		return escala;
	}

	public List<Escala> getEscalasPorMes(int mes, int ano) {
		String hql = "SELECT e FROM Escala e " + "WHERE month(e.dataEscala) =:mes AND year(e.dataEscala) =:ano";
		TypedQuery<Escala> query = manager.createQuery(hql, Escala.class);
		query.setParameter("mes", mes);
		query.setParameter("ano", ano);
		return query.getResultList();
	}

	@Override
	public List<Escala> listar(long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	// NOT USE //

	@Override
	public Escala update(Escala idEscala) throws SQLException {
		// return manager.find(Escala.class, idEscala);
		return null;
	}

	@Override
	public void insertWithKey(Escala obj, long idObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Escala updateWithKey(Escala obj, long idObj) throws SQLException {
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
	public Escala buscarPorId(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

}
