package br.com.senai.stayFilm.bo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.dao.implementation.EscalaDao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Escala;

@Component
public class EscalaBo {

	@Autowired
	@Qualifier("escalaDao")
	private GenericDao<Escala> escalaDao;
	
	

	public void insert(Escala escala) throws SQLException {
		escalaDao.insert(escala);
	}

	public void delete(Long idEscala) throws SQLException {
		escalaDao.delete(idEscala);
	}

	public Escala update(Escala escala) throws SQLException {
		return escalaDao.update(escala);
	}

	public Escala search(Long idEscala) {
		return escalaDao.search(idEscala);
	}

	
	public List<Escala> listarEscala(){
		return ((EscalaDao) escalaDao).listaEscalaGeral();
	}
	
	/**
	 * Métod responsável por inserir a escala
	 * @param escala
	 * @param idColaborador
	 */
	public void insertWithKey(Escala escala, long idColaborador) {
		escalaDao.insertWithKey(escala, idColaborador);
	}
	
	/**
	 * Metodo responsavel por realizar a chamada da escala correspondente ao mes atual do colaborador
	 * @param idColaborador
	 * @return lista dos dias escalados
	 */
	public List<Escala>listarPorMesPorColaborador(Colaborador idColaborador, int mes, int ano){
		return((EscalaDao)escalaDao).listaEscala(idColaborador, mes, ano);
	}
	
	
	/**
	 * realiza a listagem da escala por colaborador
	 * @param idColaborador
	 * @return
	 */
	public List<Escala>listarEscalaColaborador (long idColaborador){
		return ((EscalaDao)escalaDao).listar(idColaborador);
	}
	
	/**
	 * realiza a lista da escala passando os parametros apenas do mes e ano, todos os colaboradores
	 * @param mes
	 * @param ano
	 * @return lista com a escala de todos colaboradores
	 */
	public List<Escala> getEscalasPorMes(int mes, int ano) {
		return ((EscalaDao)escalaDao).getEscalasPorMes(mes, ano);
	}
	
	public List<Escala> listaPorDataEscala(Date data){
		return ((EscalaDao)escalaDao).listaPorDataEscala(data);
	}
	
	/*public List<Escala> listarEscala(){
	return ((EscalaDao) escalaDao).listaEscalaGeral();
}*/
	/*public Escala updateWithKey(Escala escala, long idColaborador) throws SQLException {
		return escalaDao.updateWithKey(escala, idColaborador);
	}*/
	
	
	
	
	
}
