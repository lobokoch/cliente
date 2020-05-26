package br.com.kerubin.api.cadastros.agenda.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.kerubin.api.cadastros.agenda.model.AgendaDTO;
import br.com.kerubin.api.cadastros.agenda.model.AgendaResumoDTO;
import br.com.kerubin.api.cadastros.agenda.model.CompromissoDTO;
import br.com.kerubin.api.cadastros.agenda.model.ParametrosAgenda;
import br.com.kerubin.api.cadastros.agenda.model.RecursoDTO;
import br.com.kerubin.api.cadastros.cliente.entity.compromisso.CompromissoEntity;
import br.com.kerubin.api.cadastros.cliente.entity.recurso.RecursoEntity;

@Service
public class AgendaServiceImpl implements AgendaService {
	
	@Inject
	private AgendaDataProvider agendaDataProvider;
	
	@Transactional(readOnly = true)
	@Override
	public AgendaDTO getAgendaDoMes(ParametrosAgenda parametros) {
		
		List<CompromissoEntity> comprimissosDoMes = agendaDataProvider.getComprimissosDoMes(parametros);
		List<CompromissoDTO> compromissos = comprimissosDoMes.stream().map(this::toCompromissoDTO).collect(Collectors.toList());
		List<RecursoDTO> recursos = agendaDataProvider.getAllRecursosDTO();
		
		recursos.forEach(it -> {
			ParametrosAgenda params = new ParametrosAgenda();
			params.setData(LocalDate.now());
			params.setRecursoEmails(Arrays.asList(it.getEmail()));
			
			long count = agendaDataProvider.countCompromissosDoRecurso(params);
			it.setCompromissosCount(count);
		});
		
		return new AgendaDTO(compromissos, recursos);
	}
	
	@Override
	public AgendaResumoDTO countCompromissosDoRecurso(ParametrosAgenda parametros) {
		
		Long count = agendaDataProvider.countCompromissosDoRecurso(parametros);
		
		return new AgendaResumoDTO(count);
	}
	
	private CompromissoDTO toCompromissoDTO(CompromissoEntity it) {
		CompromissoDTO result = new CompromissoDTO();
		
		result.setId(it.getId());
		result.setTitulo(it.getTitulo());
		result.setCliente(it.getCliente() != null ? it.getCliente().getNome(): null);
		result.setDataIni(it.getDataIni());
		result.setHoraIni(it.getHoraIni());
		result.setDataFim(it.getDataFim());
		result.setHoraFim(it.getHoraFim());
		result.setDiaTodo(it.getDiaTodo());
		result.setSituacao(it.getSituacao());
		result.setDescricao(it.getDescricao());
		result.setLocal(it.getLocal());
		result.setRecursos(toRecursoDTO(it.getRecursos()));
		
		return result;
		
	}

	private List<RecursoDTO> toRecursoDTO(Set<RecursoEntity> recursos) {
		return recursos != null ? 
				recursos.stream()
				.map(rec -> new RecursoDTO(rec.getId(), rec.getNome(), rec.getEmail(), 0L))
				.collect(Collectors.toList()) :
				Collections.emptyList();
	}

}
