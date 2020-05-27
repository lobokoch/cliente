package br.com.kerubin.api.cadastros.agenda.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import br.com.kerubin.api.cadastros.agenda.model.ParametrosAgenda;
import br.com.kerubin.api.cadastros.agenda.model.RecursoDTO;
import br.com.kerubin.api.cadastros.cliente.entity.compromisso.CompromissoEntity;

public interface AgendaDataProvider {

	List<CompromissoEntity> getComprimissosDoMes(ParametrosAgenda params);

	List<RecursoDTO> getAllRecursosDTO();

	Long countCompromissosDoRecurso(ParametrosAgenda parametros);

	long countCompromissosDoRecursoNoPeriodo(UUID ignoredId, String email, LocalDate dataIni, LocalTime horaIni, 
			LocalDate dataFim, LocalTime horaFim);

}
