package br.com.senai.stayFilm.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.senai.stayFilm.dao.implementation.EscalaDao;
import br.com.senai.stayFilm.model.Escala;

public class EscalaBo {

	EscalaDao escalaDao;

	public EscalaBo() {
		escalaDao = new EscalaDao();
	}

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

	public void insertWithKey(Escala escala, long idColaborador) {
		escalaDao.insertWithKey(escala, idColaborador);
	}

	public Escala updateWithKey(Escala escala, long idColaborador) throws SQLException {
		return escalaDao.updateWithKey(escala, idColaborador);
	}

//	public List<Escala> listar(long idObj) {
//		
//	}
}
