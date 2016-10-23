package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Colaborador;


/**
 * 23/10/2016
 * @author Equipe StayFilme
 * Controller de Colaborador
 */

@RestController
public class ColaboradorRestController {

	@Autowired
	@Qualifier("colaboradorDao")
	private GenericDao<Colaborador> colaboradorDao;

	@RequestMapping(value = "/colaborador", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Colaborador> inserir(@RequestBody Colaborador colaborador) throws SQLException {

		try {
			colaboradorDao.insert(colaborador);
			URI location = new URI("/colaborador" + colaborador.getIdColaborador());
			return ResponseEntity.created(location).body(colaborador);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/colaborador/{idColaborador}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Colaborador pesquisarColaborador(@PathVariable Long idColaborador) throws SQLException {
		return colaboradorDao.search(idColaborador);
	}

	@RequestMapping(value = "/colaborador/editar/{idColaborador}", method = RequestMethod.PUT)
	public Colaborador altera(@RequestBody Colaborador colaborador, @PathVariable long idColaborador)
			throws SQLException {
		return colaboradorDao.update(colaborador);
	}

	@RequestMapping(value = "/colaborador/{idColaborador}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable long idColaborador) throws SQLException {
		colaboradorDao.delete(idColaborador);
		return ResponseEntity.noContent().build();
	}

}
