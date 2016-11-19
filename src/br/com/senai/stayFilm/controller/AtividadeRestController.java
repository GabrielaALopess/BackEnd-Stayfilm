package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.bo.AtividadeBo;
import br.com.senai.stayFilm.model.Atividade;
import br.com.senai.stayFilm.viewModel.AtividadeViewModel;
import br.com.senai.stayFilm.vizualizacao.viewModel.AtividadeVisualizacaoViewModel;

@RestController
public class AtividadeRestController {

	@Autowired
	public AtividadeBo atividadeBO;

	/**
	 * Metodo para inserir as atividade de um colaborador
	 * @param idColaborador
	 * @param viewModel
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/atividade/{idColaborador}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AtividadeVisualizacaoViewModel> inserir(@PathVariable Long idColaborador,
			@RequestBody AtividadeViewModel viewModel) throws SQLException {
		try {
			Atividade atividade = viewModel.toAtividade();
			atividadeBO.insert(atividade, idColaborador);
			URI location = new URI("/atividade" + atividade.getColaborador().getIdColaborador());
			return ResponseEntity.created(location).body(new AtividadeVisualizacaoViewModel(atividade));
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Editar as atividades de um colaborador
	 * @param atividade
	 * @param idColaborador
	 * @return
	 * @throws SQLException
	 */
	@Transactional
	@RequestMapping(value = "/atividade/editar/{idAtividade}/{idColaborador}", method = RequestMethod.PUT)
	public Atividade altera(@RequestBody Atividade atividade, @PathVariable Long idColaborador) throws SQLException {
		return atividadeBO.edit(atividade, idColaborador);
	}

	
	/**
	 * Metodo responsavel por listar as atividades quando o id do colaborador
	 * for determinado.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/lista/{idColaborador}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Atividade> listar(@PathVariable long idColaborador) {
		return atividadeBO.search(idColaborador);
	}
	
	/**
	 * Metodo responsavel por preencher os campos de atividade
	 * Alteracao entre a lista de atividades e a acao alterar
	 * @param idAtividade
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/atividade/busca/{idAtividade}", method = RequestMethod.GET)
	public Atividade buscarPorId(@PathVariable Long idAtividade) throws SQLException {
		return atividadeBO.buscarPorId(idAtividade);
	}

	
	/**
	 * Metodo responsavel por remover a atividade de um colaborador
	 * @param idAtividade
	 * @return
	 * @throws SQLException
	 */
	@Transactional
	@RequestMapping(value = "/atividade/{idAtividade}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable long idAtividade) throws SQLException {
		atividadeBO.remove(idAtividade);
		return ResponseEntity.noContent().build();
	}
	
	
	/**
	 * Metodo implementado porem nao usado
	 * @param idAtividade
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/atividade/{idAtividade}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Atividade> pesquisarAtividade(@PathVariable Long idAtividade) throws SQLException {
		return atividadeBO.search(idAtividade);
	}




	

}