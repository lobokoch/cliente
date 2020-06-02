package br.com.kerubin.api.cadastros.agenda.service;

import static br.com.kerubin.api.servicecore.util.CoreUtils.isNotEmpty;
import static br.com.kerubin.api.servicecore.util.CoreUtils.isEmpty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.kerubin.api.cadastros.agenda.model.AgendaDTO;
import br.com.kerubin.api.cadastros.agenda.model.AgendaResumoDTO;
import br.com.kerubin.api.cadastros.agenda.model.CompromissoDTO;
import br.com.kerubin.api.cadastros.agenda.model.ParametrosAgenda;
import br.com.kerubin.api.cadastros.agenda.model.ParametrosAgendaDoDia;
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
	public boolean isRecursoLivreNoPeriodo(UUID ignoredId, String email, LocalDate dataIni, LocalTime horaIni, LocalDate dataFim,
			LocalTime horaFim) {
		
		return agendaDataProvider.countCompromissosDoRecursoNoPeriodo(ignoredId, email, dataIni, horaIni, dataFim, horaFim) == 0;
	}
	
	@Transactional(readOnly = true)
	@Override
	public AgendaDTO getAgendaDoDia(ParametrosAgendaDoDia parametros) {
		List<CompromissoEntity> comprimissosDoMes = agendaDataProvider.getCompromissosDoDia(parametros);
		
		List<CompromissoDTO> compromissos = comprimissosDoMes.stream().map(this::toCompromissoDTO).collect(Collectors.toList());
		
		Map<String, RecursoDTO> recursosMap = new HashMap<>();
		compromissos.forEach(compromisso -> {
			if (isNotEmpty(compromisso.getRecursos())) {
				compromisso.getRecursos().forEach(recurso -> {
					RecursoDTO recursoDTO = recursosMap.get(recurso.getEmail());
					if (recursoDTO == null) {
						recursoDTO = new RecursoDTO(recurso.getId(), recurso.getNome(), recurso.getEmail(), 1L);
						recursosMap.put(recursoDTO.getEmail(), recursoDTO);
					} else {
						recursoDTO.setCompromissosCount(recursoDTO.getCompromissosCount() + 1);
					}
				});
			}
		});
		
		
		List<RecursoDTO> recursos = recursosMap.values().stream().collect(Collectors.toList());
		
		return new AgendaDTO(compromissos, recursos);
	}
	
	@Override
	public long countCompromissosDoRecursoNoPeriodo(UUID ignoredId, String email, LocalDate dataIni, LocalTime horaIni,
			LocalDate dataFim, LocalTime horaFim) {
		
		return agendaDataProvider.countCompromissosDoRecursoNoPeriodo(ignoredId, email, dataIni, horaIni, dataFim, horaFim);
	}
	
	@Override
	public AgendaResumoDTO countCompromissosDoRecurso(ParametrosAgenda parametros) {
		
		Long count = agendaDataProvider.countCompromissosDoRecurso(parametros);
		
		return new AgendaResumoDTO(count);
	}
	
	private CompromissoDTO toCompromissoDTO(CompromissoEntity compromisso) {
		CompromissoDTO result = new CompromissoDTO();
		
		result.setId(compromisso.getId());
		result.setTitulo(compromisso.getTitulo());
		result.setCliente(compromisso.getCliente() != null ? compromisso.getCliente().getNome(): null);
		result.setDataIni(compromisso.getDataIni());
		result.setHoraIni(compromisso.getHoraIni());
		result.setDataFim(compromisso.getDataFim());
		result.setHoraFim(compromisso.getHoraFim());
		result.setDiaTodo(compromisso.getDiaTodo());
		result.setSituacao(compromisso.getSituacao());
		result.setDescricao(compromisso.getDescricao());
		result.setLocal(compromisso.getLocal());
		result.setRecursos(toRecursoDTO(compromisso.getRecursos()));
		result.setOrganizadorEmail(compromisso.getCreatedBy());
		if (isNotEmpty(compromisso.getRecursos())) {
			
			RecursoEntity organizador = compromisso.getRecursos()
					.stream()
					.filter(it -> it.getEmail().equals(result.getOrganizadorEmail()))
					.findFirst()
					.orElse(null);
			
			if (organizador != null) {
				result.setOrganizadorNome(organizador.getNome());
			}
		}
		
		if (isEmpty(result.getOrganizadorNome())) {
			result.setOrganizadorNome(result.getOrganizadorEmail());
		}
		
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
