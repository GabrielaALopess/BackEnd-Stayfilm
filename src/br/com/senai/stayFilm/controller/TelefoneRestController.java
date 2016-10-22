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
import br.com.senai.stayFilm.model.Telefone;

@RestController
public class TelefoneRestController {

	@Autowired
	@Qualifier("telefoneDao")
	private GenericDao<Telefone> telefoneDao;

	@RequestMapping(value = "/telefone/{idColaborador}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Telefone> inserir(@PathVariable Long idColaborador, @RequestBody Telefone telefone)
			throws SQLException {

		try {

			telefoneDao.insertWithKey(telefone, idColaborador);
			URI location = new URI("/telefone" + telefone.getIdColaborador());
			return ResponseEntity.created(location).body(telefone);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}