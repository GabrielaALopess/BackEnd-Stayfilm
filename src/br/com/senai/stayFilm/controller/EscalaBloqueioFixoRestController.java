package br.com.senai.stayFilm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class EscalaBloqueioFixoRestController {
	
	

	@Autowired
	public EscalaBloqueioFixoBo escalaBloqueioFixoBo;
	
	@Autowired
	public ColaboradorBo colaboradorBo;

	@RequestMapping(value = "/escalabloqueiofixo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EscalaBloqueioFixoVisualizacaoViewModel> inserir(@RequestBody EscalaBloqueioFixoViewModel viewModel, HttpServletRequest request) throws SQLException, InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, SignatureException, IOException, JWTVerifyException {
		try {
//			JWTVerifier verifier= new JWTVerifier(ColaboradorRestController.SECRET);
//			Map<String, Object>claims = verifier.verify(token);
//			long colaboradorId = (int)claims.get("id_colaborador");
			long colaboradorId =(long) request.getAttribute("id_colaborador");
			
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
