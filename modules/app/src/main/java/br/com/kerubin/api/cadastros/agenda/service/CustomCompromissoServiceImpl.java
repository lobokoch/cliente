package br.com.kerubin.api.cadastros.agenda.service;

import java.text.MessageFormat;
import java.time.LocalTime;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.kerubin.api.cadastros.agenda.model.AgendaException;
import br.com.kerubin.api.cadastros.cliente.entity.compromisso.CompromissoEntity;
import br.com.kerubin.api.cadastros.cliente.entity.compromisso.CompromissoServiceImpl;
import static br.com.kerubin.api.servicecore.util.CoreUtils.isNotEmpty;

@Primary
@Service
public class CustomCompromissoServiceImpl extends CompromissoServiceImpl {
	
	@Inject
	private AgendaService agendaService;
	
	@Transactional(readOnly = true)
	@Override
	public CompromissoEntity create(CompromissoEntity compromissoEntity) {
		validate(compromissoEntity);
		return super.create(compromissoEntity);
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public CompromissoEntity update(UUID id, CompromissoEntity compromissoEntity) {
		validate(compromissoEntity);
		return super.update(id, compromissoEntity);
	}
	
	private void validate(CompromissoEntity entity) {
		if (Boolean.TRUE.equals(entity.getDiaTodo())) {
			if (entity.getDataFim() == null) {
				entity.setDataFim(entity.getDataIni());				
			}
			if (entity.getHoraFim() == null) {
				entity.setHoraFim(LocalTime.of(18, 0, 0));				
			}
		}
		
		if (entity.getDataFim() == null) {
			throw new AgendaException("A data de término do compromisso deve ser informada.");
		}
		
		if (entity.getHoraFim() == null) {
			throw new AgendaException("A hora de término do compromisso deve ser informada.");
		}
		
		if (entity.getDataFim().isBefore(entity.getDataIni())) {
			throw new AgendaException("A data de término do compromisso não pode ser anterior a data de início.");
		}
		
		if (entity.getDataFim().isEqual(entity.getDataIni())) {
			if (entity.getHoraFim().isBefore(entity.getHoraIni())) {
				throw new AgendaException("A hora de término do compromisso não pode ser anterior a hora de início.");				
			}
		}
		
		validateResourceIsFreeInRange(entity);
	}


	private void validateResourceIsFreeInRange(CompromissoEntity entity) {
		if (isNotEmpty(entity.getRecursos())) {
			entity.getRecursos().forEach(recurso -> {
				String email = recurso.getEmail();
				long count = agendaService.countCompromissosDoRecursoNoPeriodo(entity.getId(), email, 
						entity.getDataIni(), entity.getHoraIni(), entity.getDataFim(), entity.getHoraFim());
				
				if (count > 0) {
					String existe = "Existe";
					String comp = "compromisso";
					String confita = "conflita";
					if (count > 1) {
						existe = "Existem";
						comp = "compromissos";
						confita = "conflitam";						
					}
					throw new AgendaException(MessageFormat.format("{0} {1} {2} para \"{3}\" que {4} com o período informado.", 
							existe, count, comp, email, confita));				
				}
			});
		}
		
	}

}
