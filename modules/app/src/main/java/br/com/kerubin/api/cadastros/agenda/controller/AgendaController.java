package br.com.kerubin.api.cadastros.agenda.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kerubin.api.cadastros.agenda.model.AgendaDTO;
import br.com.kerubin.api.cadastros.agenda.model.AgendaResumoDTO;
import br.com.kerubin.api.cadastros.agenda.model.ParametrosAgenda;
import br.com.kerubin.api.cadastros.agenda.model.ParametrosAgendaDoDia;
import br.com.kerubin.api.cadastros.agenda.service.AgendaService;

@RestController
@RequestMapping("cadastros/cliente/agenda")
public class AgendaController {
	
	@Inject
	private AgendaService agendaService;
	
	@GetMapping("/agendaDoDia")
	public AgendaDTO getAgendaDoPeriodo(ParametrosAgendaDoDia parametros) {
		return agendaService.getAgendaDoDia(parametros);
	}
	
	@GetMapping("/agendaDoMes")
	public AgendaDTO getAgendaDoMes(ParametrosAgenda parametros) {
		return agendaService.getAgendaDoMes(parametros);
	}
	
	@GetMapping("/countCompromissosDoRecurso")
	public AgendaResumoDTO countCompromissosDoRecurso(ParametrosAgenda parametros) {
		return agendaService.countCompromissosDoRecurso(parametros);
	}

}
