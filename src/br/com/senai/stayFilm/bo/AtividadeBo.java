package br.com.senai.stayFilm.bo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Atividade;

@Component
public class AtividadeBo {

	@Autowired
	@Qualifier("atividadeDao")
	private GenericDao<Atividade> atividadeDao;

	public void insert(Atividade atividade, Long idColaborador) throws SQLException {
		atividadeDao.insertWithKey(atividade, idColaborador);
	}

	public List<Atividade> search(Long id) {
		return atividadeDao.listar(id);
	}

	public Atividade edit(Atividade atividade, Long idColaborador) throws SQLException {
		if (exist(atividade.getIdAtividade())) {
			return atividadeDao.updateWithKey(atividade, idColaborador);
		}
		return null;
	}

	public void remove(Long idAtividade) throws SQLException {
		if (exist(idAtividade)) {
			atividadeDao.delete(idAtividade);
		}
	}

	public boolean exist(Long id) {
		return search(id) != null;
	}

}
