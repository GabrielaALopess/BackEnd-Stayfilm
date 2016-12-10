package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Avaliacao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.EscalaBloqueioEspecifico;

@Repository
public class EscalaBloqueioEspecificoDao implements GenericDao<EscalaBloqueioEspecifico> {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@Override
	public void insert(EscalaBloqueioEspecifico escalaBloqueioEspecifico) throws SQLException {
		manager.persist(escalaBloqueioEspecifico);

	}

	@Transactional
	@Override
	public void delete(Long id) throws SQLException {
		EscalaBloqueioEspecifico escalaBloqueioEspecifico = manager.find(EscalaBloqueioEspecifico.class, id);
		manager.remove(escalaBloqueioEspecifico);

	}

	@Override
	public EscalaBloqueioEspecifico search(Long id) {
		return manager.find(EscalaBloqueioEspecifico.class, id);

	}

	public List<EscalaBloqueioEspecifico> ListarEscalaBloqueioEspecifico() {
		TypedQuery<EscalaBloqueioEspecifico> query = manager.createQuery("SELECT e FROM EscalaBloqueioEspecifico e",
				EscalaBloqueioEspecifico.class);
		return query.getResultList();
	}

	public List<EscalaBloqueioEspecifico> listaEscalaMes(Colaborador colaboradorId, int mes, int ano) {
		/*
		 * String
		 * hql="SELECT e FROM EscalaBloqueioEspecifico WHERE  month(e.dataEscala)"
		 * + "= month(now)) AND e.colaboradorId =:colaboradorId)";
		 */
		
		String hql = "SELECT e FROM EscalaBloqueioEspecifico e "
				+ "WHERE month(e.data) =:mes AND year(e.data)=:ano AND e.colaboradorId.idColaborador = :colaboradorId";
			TypedQuery<EscalaBloqueioEspecifico> query = manager.createQuery(hql, EscalaBloqueioEspecifico.class);
			query.setParameter("mes", mes);
			query.setParameter("ano", ano);
			query.setParameter("colaboradorId", colaboradorId.getIdColaborador());			
			return query.getResultList();
	}

	public 	List<EscalaBloqueioEspecifico> listaPorData(Date data){
		String hql= "SELECT e FROM EscalaBloqueioEspecifico e "
				+ "WHERE date(e.data) = date(:data) order by e.horaInicio ASC";
		TypedQuery<EscalaBloqueioEspecifico>query = manager.createQuery(hql, EscalaBloqueioEspecifico.class);
		query.setParameter("data", data);
		try{
			return query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	// TUDO ABAIXO NAO É USADO NESTE CENÁRIO

	@Override
	public EscalaBloqueioEspecifico update(EscalaBloqueioEspecifico obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithKey(EscalaBloqueioEspecifico obj, long idObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public EscalaBloqueioEspecifico updateWithKey(EscalaBloqueioEspecifico obj, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EscalaBloqueioEspecifico> listar(long idObj) {
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
	public EscalaBloqueioEspecifico buscarPorId(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta, Long filme) {
		// TODO Auto-generated method stub
		
	}

	

}
