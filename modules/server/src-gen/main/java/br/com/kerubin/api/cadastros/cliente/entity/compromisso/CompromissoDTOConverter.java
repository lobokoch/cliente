/**********************************************************************************************
Code generated by MKL Plug-in
Copyright: Kerubin - kerubin.platform@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/


package br.com.kerubin.api.cadastros.cliente.entity.compromisso;

import javax.inject.Inject;
import org.springframework.stereotype.Component;
import br.com.kerubin.api.servicecore.mapper.ObjectMapper;

@Component
public class CompromissoDTOConverter {

	@Inject
	private ObjectMapper mapper;

	public Compromisso convertEntityToDto(CompromissoEntity entity) {
		Compromisso dto = null;
		if (entity != null) {
			dto = mapper.map(entity, Compromisso.class, true); // Do not permit passwords fields go outside.
		}
		return dto;
	}


	public CompromissoEntity convertDtoToEntity(Compromisso dto) {
		CompromissoEntity entity = null;
		if (dto != null) {
			entity = mapper.map(dto, CompromissoEntity.class);
		}
		return entity;
	}


}