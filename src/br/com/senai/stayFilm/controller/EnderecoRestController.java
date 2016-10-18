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
import br.com.senai.stayFilm.model.Endereco;

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
	
	
	
	@RequestMapping(value = "/endereco/buscar/{idEndereco}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Endereco pesquisarEndereco(@PathVariable Long idEndereco) throws SQLException {
		return enderecoDao.pesquisa(idEndereco);

	}

	
	@RequestMapping(value = "/endereco/editar/{idEndereco}", 
			method = RequestMethod.PUT)
	public Endereco altera(@RequestBody Endereco endereco) throws SQLException {
		return enderecoDao.altera(endereco);

	}
	
	@RequestMapping(value = "/endereco/{idEndereco}", 
			method = RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable Long idEndereco) throws SQLException {
		enderecoDao.exclui(idEndereco);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
