package br.com.senai.stayFilm.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.stayFilm.dao.GenericDao;
import br.com.senai.stayFilm.dao.implementation.EscalaBloqueioEspecificoDao;
import br.com.senai.stayFilm.dao.implementation.EscalaBloqueioFixoDao;
import br.com.senai.stayFilm.dao.implementation.EscalaDao;
import br.com.senai.stayFilm.model.Colaborador;
import br.com.senai.stayFilm.model.Escala;
import br.com.senai.stayFilm.model.EscalaBloqueioEspecifico;
import br.com.senai.stayFilm.model.EscalaBloqueioFixo;
import br.com.senai.stayFilm.model.EscalaMensal;
import br.com.senai.stayFilm.model.HorariosPessoaEscalaDia;
import br.com.senai.stayFilm.model.PessoaBloqueadaDia;
import br.com.senai.stayFilm.model.PessoaEscalaDia;

@Component
public class EscalaMensalBo {

	@Autowired
	@Qualifier("escalaDao")
	private GenericDao<Escala> escalaDao;

	@Autowired
	@Qualifier("escalaBloqueioEspecificoDao")
	private GenericDao<EscalaBloqueioEspecifico> escalaBloqueioEspecificoDao;

	@Autowired
	@Qualifier("colaboradorDao")
	private GenericDao<Colaborador> colaboradorDao;

	@Autowired
	@Qualifier("escalaBloqueioFixoDao")
	private GenericDao<EscalaBloqueioFixo> escalaBloqueioFixoDao;
	
	@Autowired
	private EscalaBo escalaBo;
	
	@Autowired
	private EscalaBloqueioFixoBo  escalaBloqueioFixoBo;
	
	@Autowired
	private EscalaBloqueioEspecificoBo escalaBloqueioEspecificosBo;
	
	
	
	/**
	 * metodo para estruturar a escala do colaborador (MINHA ESCALA)
	 * @param idColaborador
	 * @param mes
	 * @param ano
	 * @return
	 */
	public List<EscalaMensal> escalaColaboradorMes(long idColaborador, int mes, int ano) {

		Colaborador colaborador = colaboradorDao.buscarPorId(idColaborador);

		List<EscalaBloqueioFixo> fixas = ((EscalaBloqueioFixoDao) escalaBloqueioFixoDao).ListarEscalaBloqueio(idColaborador);
		List<EscalaBloqueioEspecifico> especificos = ((EscalaBloqueioEspecificoDao) escalaBloqueioEspecificoDao)
				.listaEscalaMes(colaborador, mes, ano);
		List<Escala> escalas = ((EscalaDao) escalaDao).listaEscala(colaborador, mes, ano);


		int dias = LocalDate.of(ano, mes, 1).getMonth().length(false);
		List<LocalDate> datas = new ArrayList<>();
		for (int dia = 1; dia <= dias; dia++) {
			
			datas.add(LocalDate.of(ano, mes, dia));
		}

		return montarEscala(fixas, especificos, escalas, datas);
	}


	
	/**
	 * metodo responsavel por realizar  a montagem da escala (MINHA ESCALA)
	 * @param fixas
	 * @param especificos
	 * @param escalas
	 * @param datas
	 * @return
	 */
	public List<EscalaMensal> montarEscala(List<EscalaBloqueioFixo> fixas, List<EscalaBloqueioEspecifico> especificos,
			List<Escala> escalas, List<LocalDate> datas) {

		List<EscalaMensal> listaEscalaMensal = new ArrayList<>();

		//primeiro for que compara a data(dia fazendo o for percorrer ate o ultimo dia do mes)
		for (LocalDate data : datas) {
			//construtor do Escala mensal
			EscalaMensal escalaMontada = new EscalaMensal();
			escalaMontada.setDia((Integer) data.getDayOfMonth());
			escalaMontada.setBloqueado(new ArrayList<String>());
			escalaMontada.setEscalados(new ArrayList<String>());
			//primeira expressao lambda para realizar uma lista de escala Especifica , dia a dia, e de forma performatica
			//pesquisar sobre o (stream e filter) 
			
			for (EscalaBloqueioEspecifico escala : especificos) {
				if(escala.getData().getDate() == data.getDayOfMonth()){
					long id = escala.getIdBloqueioEspecifico();
					int horarioInicio = escala.getHoraInicio();
					int horariofim= escala.getHoraFim();
					String horario =  horarioInicio + " - "+ horariofim +" h";
					escalaMontada.getBloqueado().add( horario);
					
				}
				
			}
//			List<Escala> escalaFiltrada = escalas.stream()
//					.filter(fix -> fix.getDataEscala().getDay() == data.getDayOfMonth()).collect(Collectors.toList());
//			for (Escala escala : escalaFiltrada) {
			for (EscalaBloqueioFixo fixa : fixas){
				if(data.getDayOfWeek().getValue() == fixa.getDiaSemana().ordinal() ){
					int horarioInicio = fixa.getHoraInicio();
					int horarioFim = fixa.getHoraFim();
					String horario = horarioInicio + " - "+ horarioFim + " h";
					escalaMontada.getBloqueado().add(horario);
				}
				
			}
			//listaEscalaMensal.add(escalaMontada);
//			List<EscalaBloqueioFixo> escalaFiltradaFix = fixas.stream()
//					.filter(fix -> fix.getDiaSemana().ordinal() == data.getDayOfWeek().getValue())
//					.collect(Collectors.toList());
			for (Escala escala : escalas) {
				if(data.getDayOfMonth() == escala.getDataEscala().getDate()){
					int horarioInicio = escala.getHoraEscalaInicio();
					int horarioFim = escala.getHoraEscalaFim();
					String horario = horarioInicio + " - "+ horarioFim + " h";
					escalaMontada.getEscalados().add(horario);
				}
			}
			listaEscalaMensal.add(escalaMontada);
		}

		return listaEscalaMensal;
	}


	/**
	 * metodo para criar os dias Concluidos do mes
	 * @param mes
	 * @param ano
	 * @return
	 */
	public List<Integer>diasConcluidosMes(int mes, int ano){
		List<Escala> escalas=  escalaBo.getEscalasPorMes(mes, ano);
		List<Date> dataEscala = getDistinctDias((List<Escala>) escalas);
		List<Integer> diasConcluidos = new ArrayList<Integer>();
		
		for (Date data: dataEscala) {
			List <Integer>horariosConcluidosData = new ArrayList<>();
			
			for (Escala escala: escalas) {
				
				if(escala.getDataEscala() ==data){
					int horario = escala.getHoraEscalaInicio();
					while(horario <= escala.getHoraEscalaFim()){
						if(!horariosConcluidosData.contains(horario)){
							horariosConcluidosData.add(horario);
						}
						horario++;
					}
					
				}
				if(horariosConcluidosData.size() == 15){
					Calendar c = Calendar.getInstance();
					c.setTime(data);
					Integer dia = c.get(Calendar.DAY_OF_MONTH);
					diasConcluidos.add(dia);
				}
			}
		}
		
		
		return diasConcluidos;

	}


	/**
	 * metodo para pegar os dias destintos
	 * @param escalas
	 * @return
	 */
	public List<Date> getDistinctDias(List<Escala> escalas){
		ArrayList<Date> datas = new ArrayList<Date>();
		for (Escala escala : escalas) {
			if(!datas.contains(escala.getDataEscala().getDate())){
				datas.add(escala.getDataEscala());
			}
		}
		return datas;
	}
	
	
	
	
	/**
	 * metodo para retornar um range de horarios 
	 * @param horarioInicio
	 * @param horarioFim
	 * @return
	 */
	// retorna range de horários baseado em um horario inicial e um final
	public List<Integer>retornaRangeHorarios(int horarioInicio, int horarioFim){
		List<Integer>horarios= new ArrayList<>();
		int horario=horarioInicio;
		while(horario <= horarioFim){
			horarios.add(horario);
			horario ++;
		}
		return horarios;
	}

	
	
	public List<PessoaBloqueadaDia> pessoaBloqueadaData(Date data){
		List<PessoaBloqueadaDia> pessoasBloqueadas = new ArrayList<>();
		
		List<EscalaBloqueioFixo>fixas = escalaBloqueioFixoBo.listarFixosDiaEspecifico(data);
		List<EscalaBloqueioEspecifico> especificas= escalaBloqueioEspecificosBo.listaPorData(data);
		
		// constrói lista de colaboradores que foram escalados
		List<Colaborador> colaboradores = new ArrayList<>();
		for (EscalaBloqueioFixo fixa : fixas){
			if(!colaboradores.contains(fixa.getColaborador())){
				colaboradores.add(fixa.getColaborador());
			}
		}
		for (EscalaBloqueioEspecifico especifica: especificas){
			if(!colaboradores.contains(especifica.getColaboradorId())){
				colaboradores.add(especifica.getColaboradorId());
				// TO-DO: trocar o nome do gerColaboradorId(), está retornado o colaborador. o certo é getColaborador()
			}
		}
		
		
		PessoaBloqueadaDia pessoa = new PessoaBloqueadaDia();
		pessoa.setHorario(new ArrayList<>());
		for (Colaborador colaborador: colaboradores){
			pessoa.setId(colaborador.getIdColaborador());
			pessoa.setNome(colaborador.getNome());
			pessoa.getHorario().clear();   //caso der ruim criar um metodo pra limpar.
			
		for(EscalaBloqueioFixo fixa : fixas){
			if(fixa.getColaborador().getIdColaborador() == pessoa.getId()){
				List<Integer> rangeHorarios = retornaRangeHorarios(fixa.getHoraInicio(),fixa.getHoraFim());
				pessoa.addListaHorarios(rangeHorarios);
			}
		}
		for(EscalaBloqueioEspecifico especifica : especificas){
			if(especifica.getColaboradorId().getIdColaborador() == pessoa.getId()){
				List<Integer> rangehorarios = retornaRangeHorarios(especifica.getHoraInicio(), especifica.getHoraFim()); 
				pessoa.addListaHorarios(rangehorarios);
			}
			
		}
		pessoasBloqueadas.add(pessoa);
	}
		return pessoasBloqueadas;
	}
	
	
	
	
	public List<PessoaEscalaDia> pessoaEscalaData(Date data){
		// lista que guarda pessoas que foram escaladas. Essa lista é o retorno do método
		List<PessoaEscalaDia> pessoaEscaladas = new ArrayList<>();
		
		// buscar todas as escalas de uma datas
		List<Escala> escalas = escalaBo.listaPorDataEscala(data);
		
		// constrói lista de colaboradores que foram escalados
		List<Colaborador> colaboradores = new  ArrayList<>();
		for(Escala escala: escalas){
			if(!colaboradores.contains(escala.getColaborador())){
				colaboradores.add(escala.getColaborador());
			}		
		}
		
		PessoaEscalaDia pessoa = new PessoaEscalaDia();
		 
		pessoa.setHorarios(new ArrayList<HorariosPessoaEscalaDia>());
		for( Colaborador colaborador: colaboradores){
			pessoa.setId(colaborador.getIdColaborador());
			pessoa.setNome(colaborador.getNome());
			pessoa.getHorarios().clear();
			for(Escala escala: escalas){
				if(escala.getColaborador().getIdColaborador()== pessoa.getId()){
					pessoa.addHorario(new HorariosPessoaEscalaDia(escala.getHoraEscalaInicio(), escala.getHoraEscalaFim()));
				}
			}
			 pessoaEscaladas.add(pessoa);
		}

		return pessoaEscaladas;
	}

}
