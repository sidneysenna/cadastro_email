package br.tec.email.emailapp.domain.hu.pesquisarcadastro;

import br.tec.email.emailapp.domain.entity.Cliente;

public class PesquisarCadastroHU implements PesquisarCadastro {

	private PesquisarCadastroRepository repository;
	
	public PesquisarCadastroHU(PesquisarCadastroRepository repository) {
		this.repository = repository;
	}

	@Override
	public Cliente buscarCadastroPorEmail(String email) throws EmailNaoInformadoException {
		
		if(email == null) 
			throw new EmailNaoInformadoException();
		
		return repository.buscarCadastroPorEmail(email);
	}

}
