package br.com.senai.stayFilm.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class EscalaBloqueioFixoRestController {
	
	
//	@Autowired
//	public EscalaBloqueioFixoBo escalaBloqueioFixoBo;
//
//	@RequestMapping(value = "/escalabloqueiofixo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ResponseEntity<EscalaBloqueioFixoVisualizacaoViewModel> inserir(@RequestBody EscalaBloqueioFixoViewModel viewModel, HttpServletRequest request) throws SQLException, InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, SignatureException, IOException, JWTVerifyException {
//		String token = request.getHeader("Authorization");
//		try {
//			JWTVerifier verifier= new JWTVerifier(UsuarioRestController.SECRET);
//			Map<String, Object>claims = verifier.verify(token);
//			Long colaboradorId = (Long)claims.get("colaborador_id");
//			
//			ColaboradorBo colaboradorBo = new ColaboradorBo(); 
//			Colaborador colaborador = colaboradorBo.buscar(colaboradorId);
//			EscalaBloqueioFixo escala = viewModel.toEscala(colaborador);
//			escalaBloqueioFixoBo.insert(escala);
//			
//			URI location = new URI("/escalabloqueiofixo" + escala.getIdBloqueiofixo());
//			return ResponseEntity.created(location).body(new EscalaBloqueioFixoVisualizacaoViewModel(escala));
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	

}
