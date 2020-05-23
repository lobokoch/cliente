/**********************************************************************************************
Code generated by MKL Plug-in
Copyright: Kerubin - kerubin.platform@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

package br.com.kerubin.api.cadastros.cliente.entity.recurso;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import br.com.kerubin.api.database.entity.AuditingEntity;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

@Entity
@Table(name = "recurso")
public class RecursoEntity extends AuditingEntity {

	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Id
	@Column(name="id")
	private java.util.UUID id;
	
	@NotBlank(message="\"Nome\" é obrigatório.")
	@Size(max = 255, message = "\"Nome\" pode ter no máximo 255 caracteres.")
	@Column(name="nome")
	private String nome;
	
	@Size(max = 255, message = "\"E-mail\" pode ter no máximo 255 caracteres.")
	@Email(message="O 'E-mail' informado é inválido.")
	@Column(name="email")
	private String email;
	
	@Column(name="ativo")
	private Boolean ativo = true;
	
	public java.util.UUID getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
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
	
	public void setEmail(String email) {
		this.email = email != null ? email.trim() : email; // Chamadas REST fazem trim.
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public void assign(RecursoEntity source) {
		if (source != null) {
			this.setId(source.getId());
			this.setNome(source.getNome());
			this.setEmail(source.getEmail());
			this.setAtivo(source.getAtivo());
			this.setCreatedBy(source.getCreatedBy());
			this.setCreatedDate(source.getCreatedDate());
			this.setLastModifiedBy(source.getLastModifiedBy());
			this.setLastModifiedDate(source.getLastModifiedDate());
		}
	}
	
	public RecursoEntity clone() {
		return clone(new java.util.HashMap<>());
	}
	
	public RecursoEntity clone(java.util.Map<Object, Object> visited) {
		if (visited.containsKey(this)) {
			return (RecursoEntity) visited.get(this);
		}
				
		RecursoEntity theClone = new RecursoEntity();
		visited.put(this, theClone);
		
		theClone.setId(this.getId());
		theClone.setNome(this.getNome());
		theClone.setEmail(this.getEmail());
		theClone.setAtivo(this.getAtivo());
		theClone.setCreatedBy(this.getCreatedBy());
		theClone.setCreatedDate(this.getCreatedDate());
		theClone.setLastModifiedBy(this.getLastModifiedBy());
		theClone.setLastModifiedDate(this.getLastModifiedDate());
		
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
		RecursoEntity other = (RecursoEntity) obj;
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
