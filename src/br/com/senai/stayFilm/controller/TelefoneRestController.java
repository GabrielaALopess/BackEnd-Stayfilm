package br.com.senai.stayFilm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
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