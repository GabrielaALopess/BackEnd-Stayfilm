package br.com.senai.stayFilm.controller;

import java.io.IOException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWTVerifyException;

import br.com.senai.stayFilm.bo.ColaboradorBo;
import br.com.senai.stayFilm.bo.EscalaBloqueioEspecificoBo;
import br.com.senai.stayFilm.bo.EscalaBloqueioFixoBo;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.EscalaBloqueioEspecifico;
import br.com.senai.stayFilm.model.EscalaBloqueioFixo;
import br.com.senai.stayFilm.viewModel.EscalaBloqueioFixoViewModel;
import br.com.senai.stayFilm.vizualizacao.viewModel.EscalaBloqueioFixoVisualizacaoViewModel;


@CrossOrigin
@RestController
public class EscalaBloqueioFixoRestController {
	
	

	@Autowired
	public EscalaBloqueioFixoBo escalaBloqueioFixoBo;
	
	@Autowired
	public ColaboradorBo colaboradorBo;

	@RequestMapping(value = "/escalabloqueiofixo/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EscalaBloqueioFixoVisualizacaoViewModel> inserir(@RequestBody EscalaBloqueioFixoViewModel viewModel,@PathVariable long id) throws SQLException, InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, SignatureException, IOException, JWTVerifyException {
		try {
//			JWTVerifier verifier= new JWTVerifier(ColaboradorRestController.SECRET);
//			Map<String, Object>claims = verifier.verify(token);
//			long colaboradorId = (int)claims.get("id_colaborador");
			long colaboradorId =id;
			
			Colaborador colaborador = colaboradorBo.buscar(colaboradorId);
			EscalaBloqueioFixo escala = viewModel.toEscala(colaborador);
			escalaBloqueioFixoBo.insert(escala);
			
			URI location = new URI("/escalabloqueiofixo" + escala.getIdBloqueiofixo());
			return ResponseEntity.created(location).body(new EscalaBloqueioFixoVisualizacaoViewModel(escala));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
	}
	
	
	
	@RequestMapping(value = "/listarBloqueioFixo/{idColaborador}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<EscalaBloqueioFixo> listarTodasEscalas(@PathVariable Long idColaborador) throws SQLException {
		//long colaboradorId = (long) request.getAttribute("id_colaborador");
		
		return escalaBloqueioFixoBo.ListarEscalaBloqueio(idColaborador);
	}
	
	
	
}
