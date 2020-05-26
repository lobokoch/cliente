package br.com.kerubin.api.cadastros.agenda.service;

import java.time.LocalTime;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.kerubin.api.cadastros.agenda.model.AgendaException;
import br.com.kerubin.api.cadastros.cliente.entity.compromisso.CompromissoEntity;
import br.com.kerubin.api.cadastros.cliente.entity.compromisso.CompromissoServiceImpl;

@Primary
@Service
public class CustomCompromissoServiceImpl extends CompromissoServiceImpl {
	
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
	}

}
