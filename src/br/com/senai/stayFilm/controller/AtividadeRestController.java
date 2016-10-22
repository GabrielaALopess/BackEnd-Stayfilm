package br.com.senai.stayFilm.controller;

public class AtividadeRestController {

//	@Autowired
//	@Qualifier("atividadeDao")
//	private GenericDao<Atividade> atividadeDao;
//
//	@RequestMapping(value = "/atividade", method = RequestMethod.POST)
//	public ResponseEntity<Atividade> inserir(@RequestBody Atividade atividade) throws SQLException {
//
//		try {
//			atividadeDao.inclui(atividade);
//			URI location = new URI("/usuario" + atividade.getIdAtividade());
//			return ResponseEntity.created(location).body(atividade);
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	@RequestMapping(value = "/resposta/{idAtividade}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public Atividade pesquisarAtividade(@PathVariable Long idAtividade) throws SQLException {
//		return atividadeDao.pesquisa(idAtividade);
//
//	}
//
//	@RequestMapping(value = "/resposta/editar/{idAtividade}", method = RequestMethod.PUT)
//	public Atividade altera(@RequestBody Atividade atividade) throws SQLException {
//		return atividadeDao.altera(atividade);
//
//	}
//
//	@RequestMapping(value = "/resposta/{idAtividade}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> remover(@PathVariable long idAtividade) throws SQLException {
//		atividadeDao.exclui(idAtividade);
//		return ResponseEntity.noContent().build();
//	}

}