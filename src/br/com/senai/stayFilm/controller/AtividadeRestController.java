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

import br.com.senai.stayFilm.bo.AtividadeBo;
import br.com.senai.stayFilm.model.Atividade;

@RestController
public class AtividadeRestController {
	@Autowired
	public AtividadeBo atividadeBO;

	@RequestMapping(value = "/atividade/{idColaborador}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Atividade> inserir(@PathVariable Long idColaborador, @RequestBody Atividade atividade)
			throws SQLException {
		System.out.println(atividadeBO);

		try {
			atividadeBO.insert(atividade,idColaborador);
			URI location = new URI("/atividade" + atividade.getIdColaborador());
			return ResponseEntity.created(location).body(atividade);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//	@RequestMapping(value = "/atividade/{idAtividade}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public Atividade pesquisarAtividade(@PathVariable Long idAtividade) throws SQLException {
//		return atividadeDao.search(idAtividade);
//	}
//
//
//	@Transactional
//	@RequestMapping(value = "/atividade/editar/{idAtividade}/{idColaborador}", method = RequestMethod.PUT)
//	public Atividade altera(@RequestBody Atividade atividade, @PathVariable long idColaborador) throws SQLException {
//		return atividadeDao.updateWithKey(atividade, idColaborador);
//	}
//
//	@Transactional
//	@RequestMapping(value = "/atividade/{idAtividade}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> remover(@PathVariable long idAtividade) throws SQLException {
//		atividadeDao.delete(idAtividade);
//		return ResponseEntity.noContent().build();
//	}
//
//	/**
//	 * Metodo responsavel por listar as atividades quando o id do colaborador for determinado.
//	 * @return
//	 */
//	@RequestMapping(value="/lista/{idColaborador}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public List<Atividade> listar(@PathVariable long idColaborador){
//		return atividadeDao.listar(idColaborador);
//	}
	
}