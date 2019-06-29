/**********************************************************************************************
Code generated with MKL Plug-in version: 6.0.2
Code generated at time stamp: 2019-06-29T10:11:35.836
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.cliente.entity.cliente;

import br.com.kerubin.api.messaging.core.DomainEvent;

public class ClienteEvent implements DomainEvent {
	
	public static final String CLIENTE_CREATED = "clienteCreated";
	public static final String CLIENTE_UPDATED = "clienteUpdated";
	public static final String CLIENTE_DELETED = "clienteDeleted";
	private java.util.UUID id;
	
	private String nome;
	
	private String cpfCNPJ;
	
	public ClienteEvent() {
		// Contructor for reflexion, injection, Jackson, QueryDSL, etc proposal.
	}
	
	public ClienteEvent(java.util.UUID id, String nome, String cpfCNPJ) {
		this.id = id;
		this.nome = nome;
		this.cpfCNPJ = cpfCNPJ;
	}
	
	public java.util.UUID getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpfCNPJ() {
		return cpfCNPJ;
	}
	
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpfCNPJ(String cpfCNPJ) {
		this.cpfCNPJ = cpfCNPJ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteEvent other = (ClienteEvent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return 31;
	}
	
	/* 
	@Override
	public String toString() {
		// Enabling toString for JPA entities will implicitly trigger lazy loading on all fields.
	}
	*/

}
