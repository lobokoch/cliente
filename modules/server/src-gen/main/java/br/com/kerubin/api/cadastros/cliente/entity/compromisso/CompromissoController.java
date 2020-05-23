/**********************************************************************************************
Code generated by MKL Plug-in
Copyright: Kerubin - kerubin.platform@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.cliente.entity.compromisso;

import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import br.com.kerubin.api.cadastros.cliente.common.PageResult;

		
import br.com.kerubin.api.cadastros.cliente.entity.cliente.ClienteAutoComplete;
import br.com.kerubin.api.cadastros.cliente.entity.recurso.RecursoAutoComplete;

import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("cadastros/cliente/entities/compromisso")
public class CompromissoController {
	
	@Autowired
	private CompromissoService compromissoService;
	
	@Autowired
	CompromissoDTOConverter compromissoDTOConverter;
	
	@Transactional
	@PostMapping
	public ResponseEntity<Compromisso> create(@Valid @RequestBody Compromisso compromisso) {
		CompromissoEntity compromissoEntity = compromissoService.create(compromissoDTOConverter.convertDtoToEntity(compromisso));
		return ResponseEntity.status(HttpStatus.CREATED).body(compromissoDTOConverter.convertEntityToDto(compromissoEntity));
	}
	
	@Transactional(readOnly = true)
	@GetMapping("/{id}")
	public ResponseEntity<Compromisso> read(@PathVariable java.util.UUID id) {
		try {
			CompromissoEntity compromissoEntity = compromissoService.read(id);
			return ResponseEntity.ok(compromissoDTOConverter.convertEntityToDto(compromissoEntity));
		}
		catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<Compromisso> update(@PathVariable java.util.UUID id, @Valid @RequestBody Compromisso compromisso) {
		try {
			CompromissoEntity compromissoEntity = compromissoService.update(id, compromissoDTOConverter.convertDtoToEntity(compromisso));
			return ResponseEntity.ok(compromissoDTOConverter.convertEntityToDto(compromissoEntity));
		}
		catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable java.util.UUID id) {
		compromissoService.delete(id);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PostMapping("/deleteInBulk")
	public void deleteInBulk(@RequestBody java.util.List<java.util.UUID> idList) {
		compromissoService.deleteInBulk(idList);
	}
	
	@Transactional(readOnly = true)
	@GetMapping
	public PageResult<Compromisso> list(CompromissoListFilter compromissoListFilter, Pageable pageable) {
		Page<CompromissoEntity> page = compromissoService.list(compromissoListFilter, pageable);
		List<Compromisso> content = page.getContent().stream().map(pe -> compromissoDTOConverter.convertEntityToDto(pe)).collect(Collectors.toList());
		PageResult<Compromisso> pageResult = new PageResult<>(content, page.getNumber(), page.getSize(), page.getTotalElements());
		return pageResult;
	}
	
	@Transactional(readOnly = true)
	@GetMapping("/autoComplete")
	public Collection<CompromissoAutoComplete> autoComplete(@RequestParam("query") String query) {
		Collection<CompromissoAutoComplete> result = compromissoService.autoComplete(query);
		return result;
	}
	
	
	@GetMapping("/compromissoTituloAutoComplete")
	public Collection<CompromissoTituloAutoComplete> compromissoTituloAutoComplete(@RequestParam("query") String query) {
		Collection<CompromissoTituloAutoComplete> result = compromissoService.compromissoTituloAutoComplete(query);
		return result;
	}
	
	
	// Begin relationships autoComplete 
	
	@Transactional(readOnly = true)
	@GetMapping("/clienteClienteAutoComplete")
	public Collection<ClienteAutoComplete> clienteClienteAutoComplete(@RequestParam("query") String query) {
		Collection<ClienteAutoComplete> result = compromissoService.clienteClienteAutoComplete(query);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	@GetMapping("/recursoRecursosAutoComplete")
	public Collection<RecursoAutoComplete> recursoRecursosAutoComplete(@RequestParam("query") String query) {
		Collection<RecursoAutoComplete> result = compromissoService.recursoRecursosAutoComplete(query);
		return result;
	}
	
	// End relationships autoComplete
	
}