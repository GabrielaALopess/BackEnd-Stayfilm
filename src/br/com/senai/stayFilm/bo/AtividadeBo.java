package br.com.senai.stayFilm.bo;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.dao.implementation.AtividadeDao;
import br.com.senai.stayFilm.model.Atividade;

@Component
public class AtividadeBo {

	@Autowired
	@Qualifier("atividadeDao")
	private GenericDao<Atividade> atividadeDao;

	public void insert(Atividade atividade,Long idColaborador) throws SQLException {
		atividadeDao.insertWithKey(atividade, idColaborador);
	}

	public Atividade search(Long id) {
		return atividadeDao.search(id);
	}

	public Atividade edit(Atividade atividade) throws SQLException {
		if (exist(atividade.getIdAtividade())) {
			return atividadeDao.update(atividade);
		}
		return null;
	}

	public boolean exist(Long id) {
		return search(id) != null;
	}

}
