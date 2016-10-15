package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.model.Endereco;
import br.com.senai.stayFilm.model.Resposta;

@RestController
public class EnderecoRestController {

	@Autowired
	@Qualifier("enderecoDao")
	private GenericDao<Endereco> enderecoDao;
	
	@RequestMapping(value = "/endereco", method = RequestMethod.POST)
	public ResponseEntity<Endereco> inserir(@RequestBody Endereco endereco) throws SQLException {

		try {
			enderecoDao.inclui(endereco);
			URI location = new URI("/endereco" + endereco.getIdEndereco());
			return ResponseEntity.created(location).body(endereco);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	
	
	
}
