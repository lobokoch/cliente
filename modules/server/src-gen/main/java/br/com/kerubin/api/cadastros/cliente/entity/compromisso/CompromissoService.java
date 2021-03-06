/**********************************************************************************************
Code generated by MKL Plug-in
Copyright: Kerubin - kerubin.platform@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.cliente.entity.compromisso;

import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.kerubin.api.cadastros.cliente.entity.cliente.ClienteAutoComplete;
import br.com.kerubin.api.cadastros.cliente.entity.recurso.RecursoAutoComplete;

public interface CompromissoService {
	
	public CompromissoEntity create(CompromissoEntity compromissoEntity);
	
	public CompromissoEntity read(java.util.UUID id);
	
	public CompromissoEntity update(java.util.UUID id, CompromissoEntity compromissoEntity);
	
	public void delete(java.util.UUID id);
	
	public void deleteInBulk(java.util.List<java.util.UUID> idList);
	
	public Page<CompromissoEntity> list(CompromissoListFilter compromissoListFilter, Pageable pageable);
	
	public Collection<CompromissoAutoComplete> autoComplete(String query);
	
	// Begin relationships autoComplete 
	public Collection<ClienteAutoComplete> clienteClienteAutoComplete(String query);
	public Collection<RecursoAutoComplete> recursoRecursosAutoComplete(String query);
	// End relationships autoComplete
	 
	
	public Collection<CompromissoTituloAutoComplete> compromissoTituloAutoComplete(String query);
}
