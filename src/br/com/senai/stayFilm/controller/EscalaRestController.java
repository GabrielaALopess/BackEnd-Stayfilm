package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.model.Escala;
import br.com.senai.stayFilm.viewModel.EscalaViewModel;
import br.com.senai.stayFilm.vizualizacao.viewModel.EscalaVizualizacaoViewModel;

@RestController
public class EscalaRestController {

	/*@Autowired
	private EscalaBo escalaBO;
*/
	
	
	/**
	 * Esse método insere a escala no banco de dados.
	 * @param idColaborador
	 * @param viewModel
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/escala/{idColaborador}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EscalaVizualizacaoViewModel> inserir(@PathVariable Long idColaborador,
			@RequestBody EscalaViewModel viewModel) throws SQLException {

		try {
			Escala escala = viewModel.toEscala();
		//	escalaBO.insertWithKey(escala, idColaborador);
			URI location = new URI("/escala" + escala.getIdColaborador());
			return ResponseEntity.created(location).body(new EscalaVizualizacaoViewModel(escala));
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// @RequestMapping(value = "/escala/editar/{idEscala}/{idColaborador}",
	// method = RequestMethod.PUT)
	// public Escala altera(@RequestBody Escala escala, @PathVariable long
	// idColaborador) throws SQLException {
	// return escalaDao.updateWithKey(escala, idColaborador);
	// }
	//
	// @RequestMapping(value = "/escala/{idEscala}", method =
	// RequestMethod.DELETE)
	// public ResponseEntity<Void> remover(@PathVariable long idEscala) throws
	// SQLException {
	// escalaDao.delete(idEscala);
	// return ResponseEntity.noContent().build();
	// }

}
