package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.ViewModel.TelefoneViewModel;
import br.com.senai.stayFilm.bo.TelefoneBo;
import br.com.senai.stayFilm.model.Telefone;

@RestController
public class TelefoneRestController {

//	@Autowired
//	public TelefoneBO telefoneBo;
//
//	@RequestMapping(value = "/telefone/{idColaborador}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ResponseEntity<Telefone> inserir(@PathVariable Long idColaborador, @RequestBody TelefoneViewModel viewModel)
//			throws SQLException {
//
//		try {
//			Telefone telefone = viewModel.toTelefone();
//			telefoneBo.insertWithKey(telefone, idColaborador);
//			URI location = new URI("/telefone" + telefone.getIdColaborador());
//			return ResponseEntity.created(location).body(telefone);
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}

//	@RequestMapping(value = "/telefone/{idTelefone}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public Telefone pesquisarTelefone(@PathVariable Long idTelefone) throws SQLException {
//		return telefoneDao.search(idTelefone);
//	}
//
//	@RequestMapping(value = "/telefone/editar/{idTelefone}/{idColaborador}", method = RequestMethod.PUT)
//	public Telefone altera(@RequestBody Telefone telefone, @PathVariable long idColaborador) throws SQLException {
//		return telefoneDao.updateWithKey(telefone, idColaborador);
//	}
//	
//	@RequestMapping(value = "/telefone/{idTelefone}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> remover(@PathVariable long idTelefone) throws SQLException {
//		telefoneDao.delete(idTelefone);
//		return ResponseEntity.noContent().build();
//	}


}