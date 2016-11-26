package br.com.senai.stayFilm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EscalaBloqueioEspecificoRestController {

//	@Autowired
//	public EscalaBloqueioEspecificoBo escalaBloqueioEspecificoBo;
//
//	@Autowired
//	public ColaboradorBo colaboradorBo;
//
//	@RequestMapping(value = "/escalabloqueioEspecifico", method = RequestMethod.POST, 
//			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
//			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ResponseEntity<EscalaBloqueioEspecificoVisualizacaoViewModel> inserir(@RequestBody EscalaBloqueioEspecificoViewModel viewModel,HttpServletRequest request) throws URISyntaxException{
//
//		try {
//			long colaboradorId =(long) request.getAttribute("id_colaborador");
//			
//			Colaborador colaborador = colaboradorBo.buscar(colaboradorId);
//			EscalaBloqueioEspecifico escala= viewModel.toEscala(colaborador);
//			escalaBloqueioEspecificoBo.insert(escala);
//			
//			URI location = new URI("/escalabloqueiofixo" + escala.getIdBloqueioEspecifico());
//			return ResponseEntity.created(location).body(new EscalaBloqueioEspecificoVisualizacaoViewModel(escala));
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}

}

