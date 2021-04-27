package br.tec.email.emailapp.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.tec.email.emailapp.persistence.entity.template.TemplateEntity;

@Entity
@Table(schema = "emailapp", name = "cliente")
public class ClienteEntity extends TemplateEntity<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 925102901970045187L;

	@Id @GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@NotNull
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@NotNull
	@Column(name = "email", nullable = false)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private EnderecoEntity endereco;
	
	
	public ClienteEntity() {
	}

	public ClienteEntity(String cpf, String email) {
		this.cpf = cpf;
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
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

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}
	
	
}
