package br.com.senai.stayFilm.dao.implementation;

import java.sql.SQLException;
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
import br.com.senai.stayFilm.model.EscalaBloqueioFixo;

@Repository
public class EscalaBloqueioFixoDao implements GenericDao<EscalaBloqueioFixo> {

	
	@PersistenceContext
	private EntityManager manager;

	
	@Transactional
	@Override
	public void insert(EscalaBloqueioFixo escalaBloqueioFixo) throws SQLException {
		manager.persist(escalaBloqueioFixo);
	}

	@Transactional
	@Override
	public void delete(Long idBloqueiofixo) throws SQLException {
		EscalaBloqueioFixo escalaBloqueioFixo = manager.find(EscalaBloqueioFixo.class, idBloqueiofixo);
		manager.remove(escalaBloqueioFixo);
	}

	
	@Override
	public EscalaBloqueioFixo search(Long id) {
		return manager.find(EscalaBloqueioFixo.class, id);
	}


	
	public List<EscalaBloqueioFixo> ListarEscalaBloqueio(long idColaborador){
		String hql= "SELECT e FROM  EscalaBloqueioFixo e WHERE e.colaborador.idColaborador= :colaborador";
		TypedQuery<EscalaBloqueioFixo> query = manager.createQuery(hql, EscalaBloqueioFixo.class);
			query.setParameter("colaborador", idColaborador);
			
		try {
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Passou direto :" + idColaborador);
			return null;
			
		}	
		
	}
	

	
	public 	List<EscalaBloqueioFixo> listarFixosDiaEspecifico(Date data){ 
		String hql= "SELECT e FROM EscalaBloqueioFixo e "
				+ " WHERE e.diaSemana = dayofweek(:data) order by e.horaInicio ASC";
		TypedQuery<EscalaBloqueioFixo>query = manager.createQuery(hql, EscalaBloqueioFixo.class);
		query.setParameter("data", data);
		System.out.println(data);
		try{
			return query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	 
	// TUDO ABAIXO NAO É USADO NESTE CENÁRIO
	
	@Override
	public EscalaBloqueioFixo update(EscalaBloqueioFixo escalaBloqueioFixo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insertWithKey(EscalaBloqueioFixo escalaBloqueio, long idEscala) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EscalaBloqueioFixo updateWithKey(EscalaBloqueioFixo obj, long idObj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EscalaBloqueioFixo> listar(long id) {
		//NOT USE
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta) {
		//NOT USE
		
	}

	@Override
	public List<Colaborador> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EscalaBloqueioFixo buscarPorId(Long idObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Avaliacao avaliacao, Long idColaborador, Long idResposta, Long filme) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
