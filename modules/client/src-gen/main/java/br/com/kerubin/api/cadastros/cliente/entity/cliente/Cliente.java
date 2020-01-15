/**********************************************************************************************
Code generated with MKL Plug-in version: 47.8.0
Code generated at time stamp: 2020-01-13T08:12:17.147
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.cliente.entity.cliente;

import javax.validation.constraints.NotNull;
import br.com.kerubin.api.cadastros.cliente.TipoPessoa;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import br.com.kerubin.api.cadastros.cliente.UF;

public class Cliente {

	private java.util.UUID id;
	
	@NotNull(message="\"Tipo do cliente\" é obrigatório.")
	private TipoPessoa tipoPessoa;
	
	@NotBlank(message="\"Nome\" é obrigatório.")
	@Size(max = 255, message = "\"Nome\" pode ter no máximo 255 caracteres.")
	private String nome;
	
	@Size(max = 255, message = "\"Documento (CNPJ/CPF)\" pode ter no máximo 255 caracteres.")
	private String cnpjCPF;
	
	@Size(max = 255, message = "\"Documento (IE/RG)\" pode ter no máximo 255 caracteres.")
	private String ieRG;
	
	private java.time.LocalDate dataFundacaoNascimento;
	
	@Size(max = 255, message = "\"Nome para contato\" pode ter no máximo 255 caracteres.")
	private String nomeContato;
	
	@Size(max = 255, message = "\"Telefone\" pode ter no máximo 255 caracteres.")
	private String fone;
	
	@Size(max = 255, message = "\"Celular\" pode ter no máximo 255 caracteres.")
	private String celular;
	
	@Size(max = 255, message = "\"E-mail\" pode ter no máximo 255 caracteres.")
	private String email;
	
	@Size(max = 255, message = "\"Site\" pode ter no máximo 255 caracteres.")
	private String site;
	
	@Size(max = 255, message = "\"CEP\" pode ter no máximo 255 caracteres.")
	private String cep;
	
	private UF uf;
	
	@Size(max = 255, message = "\"Cidade\" pode ter no máximo 255 caracteres.")
	private String cidade;
	
	@Size(max = 255, message = "\"Bairro\" pode ter no máximo 255 caracteres.")
	private String bairro;
	
	@Size(max = 255, message = "\"Endereço\" pode ter no máximo 255 caracteres.")
	private String endereco;
	
	@Size(max = 255, message = "\"Número\" pode ter no máximo 255 caracteres.")
	private String numero;
	
	@Size(max = 255, message = "\"Complemento\" pode ter no máximo 255 caracteres.")
	private String complemento;
	
	@Size(max = 1000, message = "\"Observações\" pode ter no máximo 1000 caracteres.")
	private String observacoes;
	
	private Boolean ativo = true;
	
	
	public Cliente() {
		// Contructor for reflexion, injection, Jackson, QueryDSL, etc proposal.
	}
	
	
	public java.util.UUID getId() {
		return id;
	}
	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCnpjCPF() {
		return cnpjCPF;
	}
	
	public String getIeRG() {
		return ieRG;
	}
	
	public java.time.LocalDate getDataFundacaoNascimento() {
		return dataFundacaoNascimento;
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
	
	public String getCep() {
		return cep;
	}
	
	public UF getUf() {
		return uf;
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
	
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCnpjCPF(String cnpjCPF) {
		this.cnpjCPF = cnpjCPF;
	}
	
	public void setIeRG(String ieRG) {
		this.ieRG = ieRG;
	}
	
	public void setDataFundacaoNascimento(java.time.LocalDate dataFundacaoNascimento) {
		this.dataFundacaoNascimento = dataFundacaoNascimento;
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
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public void setUf(UF uf) {
		this.uf = uf;
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
