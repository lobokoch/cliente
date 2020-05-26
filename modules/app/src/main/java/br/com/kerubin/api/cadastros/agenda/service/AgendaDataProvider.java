package br.com.kerubin.api.cadastros.agenda.service;

import java.util.List;

import br.com.kerubin.api.cadastros.agenda.model.ParametrosAgenda;
import br.com.kerubin.api.cadastros.agenda.model.RecursoDTO;
import br.com.kerubin.api.cadastros.cliente.entity.compromisso.CompromissoEntity;

public interface AgendaDataProvider {

	List<CompromissoEntity> getComprimissosDoMes(ParametrosAgenda params);

	List<RecursoDTO> getAllRecursosDTO();

	Long countCompromissosDoRecurso(ParametrosAgenda parametros);

}
