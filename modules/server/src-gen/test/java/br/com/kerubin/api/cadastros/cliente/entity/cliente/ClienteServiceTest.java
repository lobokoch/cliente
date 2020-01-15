/**********************************************************************************************
Code generated with MKL Plug-in version: 47.8.0
Code generated at time stamp: 2020-01-13T08:12:17.147
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.cliente.entity.cliente;

import br.com.kerubin.api.cadastros.cliente.TipoPessoa;
import br.com.kerubin.api.cadastros.cliente.UF;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import javax.inject.Inject;
import org.springframework.boot.test.mock.mockito.MockBean;
import br.com.kerubin.api.messaging.core.DomainEntityEventsPublisher;
import static org.mockito.Mockito.doAnswer;
import br.com.kerubin.api.messaging.core.DomainEventEnvelope;
import static org.mockito.ArgumentMatchers.any;
import br.com.kerubin.api.messaging.core.DomainEvent;
import br.com.kerubin.api.cadastros.cliente.CadastrosClienteConstants;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import br.com.kerubin.api.cadastros.cliente.common.PageResult;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import br.com.kerubin.api.cadastros.cliente.CadastrosClienteBaseEntityTest;


@RunWith(SpringRunner.class)
public class ClienteServiceTest extends CadastrosClienteBaseEntityTest {
	
	private static final String[] IGNORED_FIELDS = { "id" };
	
	@TestConfiguration
	static class ClienteServiceTestConfig {
		
		@Bean
		public ClienteListFilterPredicate clienteListFilterPredicate() {
			return new ClienteListFilterPredicateImpl();
		}
		
		@Bean
		public ClienteService clienteService() {
			return new ClienteServiceImpl();
		}
		
		@Bean
		public ClienteDTOConverter clienteDTOConverter() {
			return new ClienteDTOConverter();
		}
		
	}
	
	
	@Inject
	protected ClienteService clienteService;
	
	@Inject
	protected ClienteDTOConverter clienteDTOConverter;
	
	@Inject
	protected ClienteRepository clienteRepository;
	
	@MockBean
	protected DomainEntityEventsPublisher publisher;
	
	// BEGIN CREATE TESTS
	
	@Test
	public void testCreateWithAllFields() throws Exception {
		Cliente cliente = new Cliente();
		
		cliente.setId(java.util.UUID.randomUUID());
		cliente.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);
		cliente.setNome(generateRandomString(255));
		cliente.setCnpjCPF(generateRandomString(255));
		cliente.setIeRG(generateRandomString(255));
		cliente.setDataFundacaoNascimento(getNextDate());
		cliente.setNomeContato(generateRandomString(255));
		cliente.setFone(generateRandomString(255));
		cliente.setCelular(generateRandomString(255));
		cliente.setEmail(generateRandomString(255));
		cliente.setSite(generateRandomString(255));
		cliente.setCep(generateRandomString(255));
		cliente.setUf(UF.SC);
		cliente.setCidade(generateRandomString(255));
		cliente.setBairro(generateRandomString(255));
		cliente.setEndereco(generateRandomString(255));
		cliente.setNumero(generateRandomString(255));
		cliente.setComplemento(generateRandomString(255));
		cliente.setObservacoes(generateRandomString(1000));
		cliente.setAtivo(true);
		
		// BEGIN check event created.
		doAnswer(invocation -> {
			DomainEventEnvelope<DomainEvent> envelope = invocation.getArgument(0);
			
			assertThat(envelope).isNotNull();
			assertThat(envelope.getPayload()).isNotNull();
			
			ClienteEvent event = (ClienteEvent) envelope.getPayload();
			assertThat(event.getId()).isNotNull();
			assertThat(event.getTipoPessoa()).isEqualTo(cliente.getTipoPessoa());
			assertThat(event.getNome()).isEqualTo(cliente.getNome());
			assertThat(event.getCnpjCPF()).isEqualTo(cliente.getCnpjCPF());
			
			assertThat(CadastrosClienteConstants.DOMAIN).isEqualTo(envelope.getDomain());
			assertThat(CadastrosClienteConstants.SERVICE).isEqualTo(envelope.getService());
			
			assertThat("clienteCreated").isEqualTo(envelope.getPrimitive());
			assertThat("kerubin").isEqualTo(envelope.getTenant());
			assertThat("kerubin").isEqualTo(envelope.getUser());
			assertThat("kerubin").isEqualTo(envelope.getApplication());
			assertThat("entity.Cliente").isEqualTo(envelope.getKey());
			
			return null;
		}).when(publisher).publish(any());
		// END check event created.
		
		ClienteEntity clienteEntity = clienteService.create(clienteDTOConverter.convertDtoToEntity(cliente));
		em.flush();
		verify(publisher, times(1)).publish(any());
		Cliente actual = clienteDTOConverter.convertEntityToDto(clienteEntity);
		
		
		assertThat(actual).isNotNull();
		assertThat(actual.getId()).isNotNull();
		assertThat(actual).isEqualToIgnoringGivenFields(cliente, IGNORED_FIELDS);
		
		
	}
	
	@Test
	public void testCreateWithOnlyRecairedFields() throws Exception {
		Cliente cliente = new Cliente();
		
		cliente.setId(java.util.UUID.randomUUID());
		cliente.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);
		cliente.setNome(generateRandomString(255));
		
		// BEGIN check event created.
		doAnswer(invocation -> {
			DomainEventEnvelope<DomainEvent> envelope = invocation.getArgument(0);
			
			assertThat(envelope).isNotNull();
			assertThat(envelope.getPayload()).isNotNull();
			
			ClienteEvent event = (ClienteEvent) envelope.getPayload();
			assertThat(event.getId()).isNotNull();
			assertThat(event.getTipoPessoa()).isEqualTo(cliente.getTipoPessoa());
			assertThat(event.getNome()).isEqualTo(cliente.getNome());
			assertThat(event.getCnpjCPF()).isEqualTo(cliente.getCnpjCPF());
			
			assertThat(CadastrosClienteConstants.DOMAIN).isEqualTo(envelope.getDomain());
			assertThat(CadastrosClienteConstants.SERVICE).isEqualTo(envelope.getService());
			
			assertThat("clienteCreated").isEqualTo(envelope.getPrimitive());
			assertThat("kerubin").isEqualTo(envelope.getTenant());
			assertThat("kerubin").isEqualTo(envelope.getUser());
			assertThat("kerubin").isEqualTo(envelope.getApplication());
			assertThat("entity.Cliente").isEqualTo(envelope.getKey());
			
			return null;
		}).when(publisher).publish(any());
		// END check event created.
		
		ClienteEntity clienteEntity = clienteService.create(clienteDTOConverter.convertDtoToEntity(cliente));
		em.flush();
		verify(publisher, times(1)).publish(any());
		Cliente actual = clienteDTOConverter.convertEntityToDto(clienteEntity);
		
		
		assertThat(actual).isNotNull();
		assertThat(actual.getId()).isNotNull();
		assertThat(actual).isEqualToIgnoringGivenFields(cliente, IGNORED_FIELDS);
		
		
	}
	// END CREATE TESTS
	
	// BEGIN READ TESTS
	
	@Test
	public void testRead1() {
		ClienteEntity expectedClienteEntity = newClienteEntity();
		java.util.UUID id = expectedClienteEntity.getId();
		Cliente expected = clienteDTOConverter.convertEntityToDto(expectedClienteEntity);
		ClienteEntity readClienteEntity = clienteService.read(id);
		Cliente actual = clienteDTOConverter.convertEntityToDto(readClienteEntity);
		
		assertThat(actual).isEqualToComparingFieldByField(expected);
		
	}
	// END READ TESTS
	
	// BEGIN UPDATE TESTS
	
	@Test
	public void testUpdateWithAllFields() throws Exception {
		ClienteEntity oldClienteEntity = newClienteEntity();
		java.util.UUID id = oldClienteEntity.getId();
				
		Cliente cliente = new Cliente();
		cliente.setId(id);
		
		cliente.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);
		cliente.setNome(generateRandomString(255));
		cliente.setCnpjCPF(generateRandomString(255));
		cliente.setIeRG(generateRandomString(255));
		cliente.setDataFundacaoNascimento(getNextDate());
		cliente.setNomeContato(generateRandomString(255));
		cliente.setFone(generateRandomString(255));
		cliente.setCelular(generateRandomString(255));
		cliente.setEmail(generateRandomString(255));
		cliente.setSite(generateRandomString(255));
		cliente.setCep(generateRandomString(255));
		cliente.setUf(UF.SC);
		cliente.setCidade(generateRandomString(255));
		cliente.setBairro(generateRandomString(255));
		cliente.setEndereco(generateRandomString(255));
		cliente.setNumero(generateRandomString(255));
		cliente.setComplemento(generateRandomString(255));
		cliente.setObservacoes(generateRandomString(1000));
		cliente.setAtivo(true);
		
		// BEGIN check event updated.
		doAnswer(invocation -> {
			DomainEventEnvelope<DomainEvent> envelope = invocation.getArgument(0);
			
			assertThat(envelope).isNotNull();
			assertThat(envelope.getPayload()).isNotNull();
			
			ClienteEvent event = (ClienteEvent) envelope.getPayload();
			assertThat(event.getId()).isEqualTo(cliente.getId());
			assertThat(event.getTipoPessoa()).isEqualTo(cliente.getTipoPessoa());
			assertThat(event.getNome()).isEqualTo(cliente.getNome());
			assertThat(event.getCnpjCPF()).isEqualTo(cliente.getCnpjCPF());
			
			assertThat(CadastrosClienteConstants.DOMAIN).isEqualTo(envelope.getDomain());
			assertThat(CadastrosClienteConstants.SERVICE).isEqualTo(envelope.getService());
			
			assertThat("clienteUpdated").isEqualTo(envelope.getPrimitive());
			assertThat("kerubin").isEqualTo(envelope.getTenant());
			assertThat("kerubin").isEqualTo(envelope.getUser());
			assertThat("kerubin").isEqualTo(envelope.getApplication());
			assertThat("entity.Cliente").isEqualTo(envelope.getKey());
			
			return null;
		}).when(publisher).publish(any());
		// END check event updated.
		
		ClienteEntity clienteEntity = clienteService.update(id, clienteDTOConverter.convertDtoToEntity(cliente));
		em.flush();
		verify(publisher, times(1)).publish(any());
		
		Cliente actual = clienteDTOConverter.convertEntityToDto(clienteEntity);
		
		assertThat(actual).isNotNull();
		assertThat(actual.getId()).isNotNull();
		assertThat(actual).isEqualToIgnoringGivenFields(cliente, IGNORED_FIELDS);
		
		
	}
	
	@Test
	public void testUpdateWithOnlyRecairedFields() throws Exception {
		ClienteEntity oldClienteEntity = newClienteEntity();
		java.util.UUID id = oldClienteEntity.getId();
				
		Cliente cliente = new Cliente();
		cliente.setId(id);
		
		cliente.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);
		cliente.setNome(generateRandomString(255));
		
		// BEGIN check event updated.
		doAnswer(invocation -> {
			DomainEventEnvelope<DomainEvent> envelope = invocation.getArgument(0);
			
			assertThat(envelope).isNotNull();
			assertThat(envelope.getPayload()).isNotNull();
			
			ClienteEvent event = (ClienteEvent) envelope.getPayload();
			assertThat(event.getId()).isEqualTo(cliente.getId());
			assertThat(event.getTipoPessoa()).isEqualTo(cliente.getTipoPessoa());
			assertThat(event.getNome()).isEqualTo(cliente.getNome());
			assertThat(event.getCnpjCPF()).isEqualTo(cliente.getCnpjCPF());
			
			assertThat(CadastrosClienteConstants.DOMAIN).isEqualTo(envelope.getDomain());
			assertThat(CadastrosClienteConstants.SERVICE).isEqualTo(envelope.getService());
			
			assertThat("clienteUpdated").isEqualTo(envelope.getPrimitive());
			assertThat("kerubin").isEqualTo(envelope.getTenant());
			assertThat("kerubin").isEqualTo(envelope.getUser());
			assertThat("kerubin").isEqualTo(envelope.getApplication());
			assertThat("entity.Cliente").isEqualTo(envelope.getKey());
			
			return null;
		}).when(publisher).publish(any());
		// END check event updated.
		
		ClienteEntity clienteEntity = clienteService.update(id, clienteDTOConverter.convertDtoToEntity(cliente));
		em.flush();
		verify(publisher, times(1)).publish(any());
		
		Cliente actual = clienteDTOConverter.convertEntityToDto(clienteEntity);
		
		assertThat(actual).isNotNull();
		assertThat(actual.getId()).isNotNull();
		assertThat(actual).isEqualToIgnoringGivenFields(cliente, IGNORED_FIELDS);
		
		
	}
	// END UPDATE TESTS
	
	// BEGIN DELETE TESTS
	
	@Test
	public void testDelete1() {
		ClienteEntity expected = newClienteEntity();
		java.util.UUID id = expected.getId();
		
		ClienteEntity cliente = expected;
		
		expected = em.find(ClienteEntity.class, id);
		assertThat(expected).isNotNull();
		
		// BEGIN check event deleted.
		doAnswer(invocation -> {
			DomainEventEnvelope<DomainEvent> envelope = invocation.getArgument(0);
			
			assertThat(envelope).isNotNull();
			assertThat(envelope.getPayload()).isNotNull();
			
			ClienteEvent event = (ClienteEvent) envelope.getPayload();
			assertThat(event.getId()).isEqualTo(cliente.getId());
			assertThat(event.getTipoPessoa()).isEqualTo(cliente.getTipoPessoa());
			assertThat(event.getNome()).isEqualTo(cliente.getNome());
			assertThat(event.getCnpjCPF()).isEqualTo(cliente.getCnpjCPF());
			
			assertThat(CadastrosClienteConstants.DOMAIN).isEqualTo(envelope.getDomain());
			assertThat(CadastrosClienteConstants.SERVICE).isEqualTo(envelope.getService());
			
			assertThat("clienteDeleted").isEqualTo(envelope.getPrimitive());
			assertThat("kerubin").isEqualTo(envelope.getTenant());
			assertThat("kerubin").isEqualTo(envelope.getUser());
			assertThat("kerubin").isEqualTo(envelope.getApplication());
			assertThat("entity.Cliente").isEqualTo(envelope.getKey());
			
			return null;
		}).when(publisher).publish(any());
		// END check event deleted.
		
		clienteService.delete(id);
		verify(publisher, times(1)).publish(any());
		
		expected = em.find(ClienteEntity.class, id);
		assertThat(expected).isNull();
	}
	// END DELETE TESTS
	
	// BEGIN LIST TESTS
	
	@Test
	public void testList_FilteringByNome() {
		// Reset lastDate field to start LocalDate fields with today in this test. 
		resetNextDate();
		
		// Generate 33 records of data for ClienteEntity for this test.
		List<ClienteEntity> testData = new ArrayList<>();
		final int lastRecord = 33;
		final int firstRecord = 1;
		for (int i = firstRecord; i <= lastRecord; i++) {
			testData.add(newClienteEntity());
		}
		
		// Check if 33 records of ClienteEntity was generated.
		long count = clienteRepository.count();
		assertThat(count).isEqualTo(lastRecord);
		
		// Creates a list filter for entity Cliente.
		ClienteListFilter listFilter = new ClienteListFilter();
		
		// Extracts 7 records of ClienteEntity randomly from testData.
		final int resultSize = 7;
		List<ClienteEntity> filterTestData = getRandomItemsOf(testData, resultSize);
		
		// Extracts a list with only ClienteEntity.nome field and configure this list as a filter.
		List<String> nomeListFilter = filterTestData.stream().map(ClienteEntity::getNome).collect(Collectors.toList());
		listFilter.setNome(nomeListFilter);
		
		// Generates a pageable configuration, without sorting.
		int pageIndex = 0; // First page starts at index zero.
		int size = 33; // Max of 33 records per page.
		Pageable pageable = PageRequest.of(pageIndex, size);
		// Call service list method.
		Page<ClienteEntity> page = clienteService.list(listFilter, pageable);
		
		// Converts found entities to DTOs and mount the result page.
		List<Cliente> content = page.getContent().stream().map(it -> clienteDTOConverter.convertEntityToDto(it)).collect(Collectors.toList());
		PageResult<Cliente> pageResult = new PageResult<>(content, page.getNumber(), page.getSize(), page.getTotalElements());
		
		// Asserts that result has size 7, in any order and has only rows with nomeListFilter elements based on nome field.
		assertThat(pageResult.getContent())
		.hasSize(7)
		.extracting(Cliente::getNome)
		.containsExactlyInAnyOrderElementsOf(nomeListFilter);
		
		// Asserts some page result elements.
		assertThat(pageResult.getNumber()).isEqualTo(pageIndex);
		assertThat(pageResult.getNumberOfElements()).isEqualTo(7);
		assertThat(pageResult.getTotalElements()).isEqualTo(7);
		assertThat(pageResult.getTotalPages()).isEqualTo(1);
		
	}
	
	@Test
	public void testList_FilteringByNomeWithoutResults() {
		// Reset lastDate field to start LocalDate fields with today in this test. 
		resetNextDate();
					
		// Generate 33 records of data for ClienteEntity for this test.
		List<ClienteEntity> testData = new ArrayList<>();
		final int lastRecord = 33;
		final int firstRecord = 1;
		for (int i = firstRecord; i <= lastRecord; i++) {
			testData.add(newClienteEntity());
		}
		
		// Check if 33 records of ClienteEntity was generated.
		long count = clienteRepository.count();
		assertThat(count).isEqualTo(lastRecord);
		
		// Creates a list filter for entity Cliente.
		ClienteListFilter listFilter = new ClienteListFilter();
		
		// Generates a list with only ClienteEntity.nome field with 1 not found data in the database and configure this list as a filter.
		List<String> nomeListFilter = Arrays.asList(generateRandomString(255));
		listFilter.setNome(nomeListFilter);
		
		// Generates a pageable configuration, without sorting.
		int pageIndex = 0; // First page starts at index zero.
		int size = 33; // Max of 33 records per page.
		Pageable pageable = PageRequest.of(pageIndex, size);
		// Call service list method.
		Page<ClienteEntity> page = clienteService.list(listFilter, pageable);
		
		// Converts found entities to DTOs and mount the result page.
		List<Cliente> content = page.getContent().stream().map(it -> clienteDTOConverter.convertEntityToDto(it)).collect(Collectors.toList());
		PageResult<Cliente> pageResult = new PageResult<>(content, page.getNumber(), page.getSize(), page.getTotalElements());
		
		// Asserts that result has size 0 for unknown nome field.
		assertThat(pageResult.getContent()).hasSize(0);
		
	}
	// END LIST TESTS
	
	// BEGIN Autocomplete TESTS
	@Test
	public void testAutoComplete() {
		// Reset lastDate field to start LocalDate fields with today in this test. 
		resetNextDate();
					
		// Generate 33 records of data for ClienteEntity for this test.
		List<ClienteEntity> testData = new ArrayList<>();
		final int lastRecord = 33;
		final int firstRecord = 1;
		for (int i = firstRecord; i <= lastRecord; i++) {
			testData.add(newClienteEntity());
		}
		
		// Check if 33 records of ClienteEntity was generated.
		long count = clienteRepository.count();
		assertThat(count).isEqualTo(lastRecord);
		
		// Extracts 1 records of ClienteEntity randomly from testData.
		final int resultSize = 1;
		List<ClienteEntity> filterTestData = getRandomItemsOf(testData, resultSize);
		
		// Extracts a list with only ClienteEntity.nome field and configure this list as a filter.
		List<String> nomeListFilter = filterTestData.stream().map(ClienteEntity::getNome).collect(Collectors.toList());
		// Mount the autocomplete query expression and call it.
		String query = nomeListFilter.get(0);
		Collection<ClienteAutoComplete> result = clienteService.autoComplete(query);
		
		// Assert ClienteAutoComplete results.
		assertThat(result).isNotNull().hasSize(1)
		.extracting(ClienteAutoComplete::getNome)
		.containsExactlyInAnyOrderElementsOf(nomeListFilter);
	}
	
	// END Autocomplete TESTS
	
	// BEGIN ListFilter Autocomplete TESTS
	
	@Test
	public void testClienteNomeAutoComplete() {
		// Reset lastDate field to start LocalDate fields with today in this test. 
		resetNextDate();
					
		// Generate 33 records of data for ClienteEntity for this test.
		List<ClienteEntity> testData = new ArrayList<>();
		final int lastRecord = 33;
		final int firstRecord = 1;
		for (int i = firstRecord; i <= lastRecord; i++) {
			testData.add(newClienteEntity());
		}
		
		// Check if 33 records of ClienteEntity was generated.
		long count = clienteRepository.count();
		assertThat(count).isEqualTo(lastRecord);
		
		// Extracts 1 records of ClienteEntity randomly from testData.
		final int resultSize = 1;
		List<ClienteEntity> filterTestData = getRandomItemsOf(testData, resultSize);
		
		// Extracts a list with only ClienteEntity.nome field and configure this list as a filter.
		List<String> nomeListFilter = filterTestData.stream().map(ClienteEntity::getNome).collect(Collectors.toList());
		// Mount the autocomplete query expression and call it.
		String query = nomeListFilter.get(0);
		Collection<ClienteNomeAutoComplete> result = clienteService.clienteNomeAutoComplete(query);
		// Assert ClienteNomeAutoComplete results.
		assertThat(result).isNotNull().hasSize(1)
		.extracting(ClienteNomeAutoComplete::getNome)
		.containsExactlyInAnyOrderElementsOf(nomeListFilter);
	}
	
	// END ListFilter Autocomplete TESTS
	
	
	// BEGIN tests for Sum Fields
	// END tests for Sum Fields
	
	// BEGIN tests for Sum Fields
	// END tests for Sum Fields
	
	// BEGIN TESTS DEPENDENCIES
	
	
	protected ClienteEntity newClienteEntity() {
		ClienteEntity clienteEntity = new ClienteEntity();
		
		clienteEntity.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);
		clienteEntity.setNome(generateRandomString(255));
		clienteEntity.setCnpjCPF(generateRandomString(255));
		clienteEntity.setIeRG(generateRandomString(255));
		clienteEntity.setDataFundacaoNascimento(getNextDate());
		clienteEntity.setNomeContato(generateRandomString(255));
		clienteEntity.setFone(generateRandomString(255));
		clienteEntity.setCelular(generateRandomString(255));
		clienteEntity.setEmail(generateRandomString(255));
		clienteEntity.setSite(generateRandomString(255));
		clienteEntity.setCep(generateRandomString(255));
		clienteEntity.setUf(UF.SC);
		clienteEntity.setCidade(generateRandomString(255));
		clienteEntity.setBairro(generateRandomString(255));
		clienteEntity.setEndereco(generateRandomString(255));
		clienteEntity.setNumero(generateRandomString(255));
		clienteEntity.setComplemento(generateRandomString(255));
		clienteEntity.setObservacoes(generateRandomString(1000));
		clienteEntity.setAtivo(true);
		
		clienteEntity = em.persistAndFlush(clienteEntity);
		return clienteEntity;
	}
	
	
	protected ClienteLookupResult newClienteLookupResult(ClienteEntity clienteEntity) {
		ClienteLookupResult cliente = new ClienteLookupResult();
		
		cliente.setId(clienteEntity.getId());
		cliente.setNome(clienteEntity.getNome());
		
		return cliente;
	}
	// END TESTS DEPENDENCIES

}