package br.com.kerubin.api.cadastros.agenda.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import br.com.kerubin.api.cadastros.agenda.model.AgendaDTO;
import br.com.kerubin.api.cadastros.agenda.model.AgendaResumoDTO;
import br.com.kerubin.api.cadastros.agenda.model.ParametrosAgenda;

public interface AgendaService {

	AgendaDTO getAgendaDoMes(ParametrosAgenda parametros);

	AgendaResumoDTO countCompromissosDoRecurso(ParametrosAgenda parametros);

	boolean isRecursoLivreNoPeriodo(UUID ignoredId, String email, LocalDate dataIni, LocalTime horaIni, LocalDate dataFim, LocalTime horaFim);

	long countCompromissosDoRecursoNoPeriodo(UUID ignoredId, String email, LocalDate dataIni, LocalTime horaIni, LocalDate dataFim,
			LocalTime horaFim);

}
