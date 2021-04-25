package br.tec.email.emailapp.domain.hu.inclusaocadastro;

import br.tec.email.emailapp.domain.entity.Cliente;

public class InclusaoCadastroHU implements InclusaoCadastro {

	private InclusaoCadastroRepository repository;
	
	public InclusaoCadastroHU(InclusaoCadastroRepository repository) {
		this.repository = repository;
	}


	@Override
	public Cliente cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException{
		
		if(repository.clienteJaCadastrado(cliente)) {
			throw new ClienteJaCadastradoException();
		}else {
			return repository.cadastrarCliente(cliente);
		}
		
	}

}
