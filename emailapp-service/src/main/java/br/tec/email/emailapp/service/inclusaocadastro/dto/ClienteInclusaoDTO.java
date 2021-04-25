package br.tec.email.emailapp.service.inclusaocadastro.dto;

public class ClienteInclusaoDTO {

	private String cpf;
	private String email;
	
	
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
	
	

}
