package br.com.senai.stayFilm.controller;


import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

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
import br.com.senai.stayFilm.bo.EscalaBloqueioEspecificoBo;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Escala;
import br.com.senai.stayFilm.model.EscalaBloqueioEspecifico;
import br.com.senai.stayFilm.viewModel.EscalaBloqueioEspecificoViewModel;
import br.com.senai.stayFilm.vizualizacao.viewModel.EscalaBloqueioEspecificoVisualizacaoViewModel;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EscalaBloqueioEspecificoRestController {


	@Autowired
	public EscalaBloqueioEspecificoBo escalaBloqueioEspecificoBo;

	@Autowired
	public ColaboradorBo colaboradorBo;

	@RequestMapping(value = "/escalabloqueioEspecifico", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EscalaBloqueioEspecificoVisualizacaoViewModel> inserir(
			@RequestBody EscalaBloqueioEspecificoViewModel viewModel, HttpServletRequest request)
			throws URISyntaxException {

		try {
			long colaboradorId = (long) request.getAttribute("id_colaborador");

			Colaborador colaborador = colaboradorBo.buscar(colaboradorId);
			EscalaBloqueioEspecifico escala = viewModel.toEscala(colaborador);
			escalaBloqueioEspecificoBo.insert(escala);

			URI location = new URI("/escalabloqueiofixo" + escala.getIdBloqueioEspecifico());
			return ResponseEntity.created(location).body(new EscalaBloqueioEspecificoVisualizacaoViewModel(escala));
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@RequestMapping(value = "/listarEscalaMes/{idColaborador}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<EscalaBloqueioEspecifico> listarTodasEscalas(@PathVariable Long idColaborador,int mes,int ano) throws SQLException {
		//long colaboradorId = (long) request.getAttribute("id_colaborador");
		Colaborador colaborador = colaboradorBo.buscar(idColaborador);
		List<EscalaBloqueioEspecifico> lista = escalaBloqueioEspecificoBo.listarPorMesPorColaborador(colaborador,mes,ano);
		return lista;
	}

}
