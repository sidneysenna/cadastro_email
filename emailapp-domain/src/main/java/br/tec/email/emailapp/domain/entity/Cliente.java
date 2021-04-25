package br.tec.email.emailapp.domain.entity;

public class Cliente {
	
	private String cpf;
	private String email;
	
	
	public Cliente() {
	}
	
	public Cliente(String cpf, String email) {
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
