package br.com.kerubin.api.cadastros.agenda.service;

import br.com.kerubin.api.cadastros.agenda.model.AgendaDTO;
import br.com.kerubin.api.cadastros.agenda.model.AgendaResumoDTO;
import br.com.kerubin.api.cadastros.agenda.model.ParametrosAgenda;

public interface AgendaService {

	AgendaDTO getAgendaDoMes(ParametrosAgenda parametros);

	AgendaResumoDTO countCompromissosDoRecurso(ParametrosAgenda parametros);

}
