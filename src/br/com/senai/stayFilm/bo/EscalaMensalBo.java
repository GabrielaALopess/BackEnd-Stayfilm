package br.com.senai.stayFilm.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<EscalaMensal> escalaColaboradorMes(long idColaborador, int mes, int ano) {

		Colaborador colaborador = colaboradorDao.buscarPorId(idColaborador);

		List<EscalaBloqueioFixo> fixas = ((EscalaBloqueioFixoDao) escalaBloqueioFixoDao).ListarEscalaBloqueio();
		List<EscalaBloqueioEspecifico> especificos = ((EscalaBloqueioEspecificoDao) escalaBloqueioEspecificoDao)
				.listaEscalaMes(colaborador, mes, ano);
		List<Escala> escalas = ((EscalaDao) escalaDao).listaEscala(colaborador, mes, ano);


		int dias = LocalDate.of(ano, mes, 1).getMonth().length(false);
		List<LocalDate> datas = new ArrayList<>();
		for (int dia = 1; dia <= dias; dia++) {
			System.out.println(ano);
			datas.add(LocalDate.of(ano, mes, dia));
		}

		return montarEscala(fixas, especificos, escalas, datas);
	}


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

			List<Escala> escalaFiltrada = escalas.stream()
					.filter(fix -> fix.getDataEscala().getDay() == data.getDayOfMonth()).collect(Collectors.toList());
			for (Escala escala : escalaFiltrada) {

				escalaMontada.getEscalados().add(escala.getHoraEscalaInicio() + " - " + escala.getHoraEscalaFim()+ " h" );
			}
			listaEscalaMensal.add(escalaMontada);
			

			List<EscalaBloqueioFixo> escalaFiltradaFix = fixas.stream()
					.filter(fix -> fix.getDiaSemana().ordinal() == data.getDayOfWeek().getValue())
					.collect(Collectors.toList());
			for (EscalaBloqueioFixo bloqFix : escalaFiltradaFix) {

				escalaMontada.getBloqueado().add(bloqFix.getHoraInicio() + " - " + bloqFix.getHoraFim()+ " h" );
			}

			for (EscalaBloqueioEspecifico escala : especificos) {
				if(escala.getData().getDate() == data.getDayOfMonth()){
					System.out.println(escala.getData().getDate());
					int horarioInicio = escala.getHoraInicio();
					int horariofim= escala.getHoraFim();
					String horario = horarioInicio + " - "+horariofim+" h";
					escalaMontada.getBloqueado().add(horario);
					System.out.println(horario);
				}
				
			}

			
		}

		return listaEscalaMensal;
	}



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



	public List<Date> getDistinctDias(List<Escala> escalas){
		ArrayList<Date> datas = new ArrayList<Date>();
		for (Escala escala : escalas) {
			if(!datas.contains(escala.getDataEscala().getDate())){
				datas.add(escala.getDataEscala());
			}
		}
		return datas;
	}
	
	
	
	
	
	// retorna range de hor�rios baseado em um horario inicial e um final
	public List<Integer>retornaRangeHorarios(int horarioInicio, int horarioFim){
		List<Integer>horarios= new ArrayList<>();
		int horario=horarioInicio;
		while(horario <= horarioFim){
			horarios.add(horario);
			horario ++;
		}
		return horarios;
	}


}
