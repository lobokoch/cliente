/**********************************************************************************************
Code generated with MKL Plug-in version: 6.0.2
Code generated at time stamp: 2019-06-29T10:11:35.836
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.cliente.entity.cliente;

import javax.validation.constraints.NotBlank;

public class Cliente {

	private java.util.UUID id;
	
	@NotBlank(message="'Nome' é obrigatório.")
	private String nome;
	
	private String cpfCNPJ;
	
	private String ieRG;
	
	private String nomeContato;
	
	private String fone;
	
	private String celular;
	
	private String email;
	
	private String site;
	
	private String cEP;
	
	private String cidade;
	
	private String bairro;
	
	private String endereco;
	
	private String numero;
	
	private String complemento;
	
	private String observacoes;
	
	private Boolean ativo = true;
	
	
	public Cliente() {
		// Contructor for reflexion, injection, Jackson, QueryDSL, etc proposal.
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
	
	public String getIeRG() {
		return ieRG;
	}
	
	public String getNomeContato() {
		return nomeContato;
	}
	
	public String getFone() {
		return fone;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSite() {
		return site;
	}
	
	public String getCEP() {
		return cEP;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	
	public Boolean getAtivo() {
		return ativo;
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
	
	public void setIeRG(String ieRG) {
		this.ieRG = ieRG;
	}
	
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}
	
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public void setCEP(String cEP) {
		this.cEP = cEP;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
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
