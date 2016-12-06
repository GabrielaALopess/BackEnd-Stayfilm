package br.com.senai.stayFilm.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.stayFilm.bo.ColaboradorBo;
import br.com.senai.stayFilm.bo.EscalaBo;
import br.com.senai.stayFilm.bo.EscalaMensalBo;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Escala;
import br.com.senai.stayFilm.model.EscalaMensal;
import br.com.senai.stayFilm.model.PessoaBloqueadaDia;
import br.com.senai.stayFilm.model.PessoaEscalaDia;
import br.com.senai.stayFilm.viewModel.EscalaViewModel;
import br.com.senai.stayFilm.vizualizacao.viewModel.EscalaVisualizacaoViewModel;

@CrossOrigin
@RestController
public class EscalaRestController {

	@Autowired
	public EscalaBo escalaBo;

	@Autowired
	public ColaboradorBo colaboradorBo;

	@Autowired
	public EscalaMensalBo escalaMensalBo;


	@RequestMapping(value = "/escala/{id}", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EscalaVisualizacaoViewModel> inserir(@RequestBody EscalaViewModel viewModel,@PathVariable long id) throws URISyntaxException{
		try{
			long colaboradorId = id;

			Colaborador colaborador = colaboradorBo.buscar(colaboradorId);
			Escala escala = viewModel.toEscala(colaborador);
			escalaBo.insert(escala);

			URI location = new URI("/escala" + escala.getIdEscala());
			return ResponseEntity.created(location).body(new EscalaVisualizacaoViewModel(escala));

		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Lista reponsavel por trazer toda as escalas atribuidas independente do colaborador faz parte do(CRUD) 
	 * @return
	 */
	@RequestMapping(value = "/listarEscalas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Escala> listarTodasEscalas(){
		return escalaBo.listarEscala();
	}

	/**
	 * Lista responsavel por retorna a escala de um colaborador passando apenas o seu idcolaborador faz parte do(CRUD)
	 * @param idColaborador
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/listarEscala/{idColaborador}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Escala> listarTodasEscalas(@PathVariable Long idColaborador) throws SQLException {
		//long colaboradorId = (long) request.getAttribute("id_colaborador");
		//Colaborador colaborador = colaboradorBo.buscar(idColaborador);
		List<Escala> lista = escalaBo.listarEscalaColaborador(idColaborador);
		return lista;
	}

	/**
	 * listar a Escala Colaborador passando por parametro, mes , ano e idColaborador
	 * @param idColaborador
	 * @param mes
	 * @param ano
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/listarEscalaMontada/{idColaborador}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<EscalaMensal> listarEscalaMontada(@PathVariable Long idColaborador, int mes, int ano) throws SQLException {
		List<EscalaMensal> lista = escalaMensalBo.escalaColaboradorMes(idColaborador, mes, ano);
		return lista;
	}

	@RequestMapping(value = "/diasConcluidosMes", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Integer> listarEscalaMontada(int mes, int ano) throws SQLException {
		List<Integer> lista = escalaMensalBo.diasConcluidosMes(mes, ano);
		return lista;
	}

	/**
	 * metodo responsavel por excluir uma escala.
	 * @param idEscala
	 * @return  null <- 204 no contest <- indica se a escala foi removido com sucesso!
	 * @throws SQLException
	 */
	@RequestMapping(value = "/private/escala/remove/{idEscala}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable long idEscala) throws SQLException {
		escalaBo.delete(idEscala);
		return ResponseEntity.noContent().build();
	}


	@RequestMapping(value = "/listaPessoasBloqueadasData/{dataEscolhida}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<PessoaBloqueadaDia> listarPessoasBloqueadasData(@PathVariable String dataEscolhida ){
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date data = (Date)formatter.parse(dataEscolhida);

			List<PessoaBloqueadaDia> lista = escalaMensalBo.pessoaBloqueadaData(data);
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@RequestMapping(value = "/listaPorDataEscala/{dataEscolhida}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<PessoaEscalaDia> listaPorDataEscala(@PathVariable String dataEscolhida){
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date data = (Date)formatter.parse(dataEscolhida);
			
			List<PessoaEscalaDia> lista = escalaMensalBo.pessoaEscalaData(data);
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}




}
