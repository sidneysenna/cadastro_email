package br.tec.email.emailapp.service.dto;

public class ClienteInclusaoDTO {

	private String cpf;
	
	private String email;
	
	private EnderecoInclusaoDTO endereco;
	
	
	
	public ClienteInclusaoDTO() {
	}
	
	
	public ClienteInclusaoDTO(String cpf, String email) {
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

	public EnderecoInclusaoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoInclusaoDTO endereco) {
		this.endereco = endereco;
	}
	
	

}
