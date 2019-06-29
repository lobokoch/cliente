/**********************************************************************************************
Code generated with MKL Plug-in version: 6.0.2
Code generated at time stamp: 2019-06-29T10:11:35.836
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/


package br.com.kerubin.api.cadastros.cliente.entity.cliente;

import javax.inject.Inject;
import org.springframework.stereotype.Component;
import br.com.kerubin.api.cadastros.cliente.ObjectMapper;

@Component
public class ClienteDTOConverter {

	@Inject
	private ObjectMapper mapper;

	public Cliente convertEntityToDto(ClienteEntity entity) {
		Cliente dto = null;
		if (entity != null) {
			dto = mapper.map(entity, Cliente.class);
		}
		return dto;
	}


	public ClienteEntity convertDtoToEntity(Cliente dto) {
		ClienteEntity entity = null;
		if (dto != null) {
			entity = mapper.map(dto, ClienteEntity.class);
		}
		return entity;
	}


}