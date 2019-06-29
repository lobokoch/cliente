/**********************************************************************************************
Code generated with MKL Plug-in version: 6.0.2
Code generated at time stamp: 2019-06-29T10:11:35.836
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.cliente.entity.cliente;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cliente")
public class ClienteEntity  {

	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Id
	@Column(name="id")
	private java.util.UUID id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf_cnpj")
	private String cpfCNPJ;
	
	@Column(name="ie_rg")
	private String ieRG;
	
	@Column(name="nome_contato")
	private String nomeContato;
	
	@Column(name="fone")
	private String fone;
	
	@Column(name="celular")
	private String celular;
	
	@Column(name="email")
	private String email;
	
	@Column(name="site")
	private String site;
	
	@Column(name="cep")
	private String cEP;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="observacoes")
	private String observacoes;
	
	@Column(name="ativo")
	private Boolean ativo = true;
	
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
		this.nome = nome != null ? nome.trim() : nome; // Chamadas REST fazem trim.
	}
	
	public void setCpfCNPJ(String cpfCNPJ) {
		this.cpfCNPJ = cpfCNPJ != null ? cpfCNPJ.trim() : cpfCNPJ; // Chamadas REST fazem trim.
	}
	
	public void setIeRG(String ieRG) {
		this.ieRG = ieRG != null ? ieRG.trim() : ieRG; // Chamadas REST fazem trim.
	}
	
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato != null ? nomeContato.trim() : nomeContato; // Chamadas REST fazem trim.
	}
	
	public void setFone(String fone) {
		this.fone = fone != null ? fone.trim() : fone; // Chamadas REST fazem trim.
	}
	
	public void setCelular(String celular) {
		this.celular = celular != null ? celular.trim() : celular; // Chamadas REST fazem trim.
	}
	
	public void setEmail(String email) {
		this.email = email != null ? email.trim() : email; // Chamadas REST fazem trim.
	}
	
	public void setSite(String site) {
		this.site = site != null ? site.trim() : site; // Chamadas REST fazem trim.
	}
	
	public void setCEP(String cEP) {
		this.cEP = cEP != null ? cEP.trim() : cEP; // Chamadas REST fazem trim.
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade != null ? cidade.trim() : cidade; // Chamadas REST fazem trim.
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro != null ? bairro.trim() : bairro; // Chamadas REST fazem trim.
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco != null ? endereco.trim() : endereco; // Chamadas REST fazem trim.
	}
	
	public void setNumero(String numero) {
		this.numero = numero != null ? numero.trim() : numero; // Chamadas REST fazem trim.
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento != null ? complemento.trim() : complemento; // Chamadas REST fazem trim.
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes != null ? observacoes.trim() : observacoes; // Chamadas REST fazem trim.
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public void assign(ClienteEntity source) {
		if (source != null) {
			this.setId(source.getId());
			this.setNome(source.getNome());
			this.setCpfCNPJ(source.getCpfCNPJ());
			this.setIeRG(source.getIeRG());
			this.setNomeContato(source.getNomeContato());
			this.setFone(source.getFone());
			this.setCelular(source.getCelular());
			this.setEmail(source.getEmail());
			this.setSite(source.getSite());
			this.setCEP(source.getCEP());
			this.setCidade(source.getCidade());
			this.setBairro(source.getBairro());
			this.setEndereco(source.getEndereco());
			this.setNumero(source.getNumero());
			this.setComplemento(source.getComplemento());
			this.setObservacoes(source.getObservacoes());
			this.setAtivo(source.getAtivo());
		}
	}
	
	public ClienteEntity clone() {
		ClienteEntity theClone = new ClienteEntity();
		theClone.setId(this.getId());
		theClone.setNome(this.getNome());
		theClone.setCpfCNPJ(this.getCpfCNPJ());
		theClone.setIeRG(this.getIeRG());
		theClone.setNomeContato(this.getNomeContato());
		theClone.setFone(this.getFone());
		theClone.setCelular(this.getCelular());
		theClone.setEmail(this.getEmail());
		theClone.setSite(this.getSite());
		theClone.setCEP(this.getCEP());
		theClone.setCidade(this.getCidade());
		theClone.setBairro(this.getBairro());
		theClone.setEndereco(this.getEndereco());
		theClone.setNumero(this.getNumero());
		theClone.setComplemento(this.getComplemento());
		theClone.setObservacoes(this.getObservacoes());
		theClone.setAtivo(this.getAtivo());
		
		return theClone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteEntity other = (ClienteEntity) obj;
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
