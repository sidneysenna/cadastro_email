package br.tec.email.emailapp.domain.hu.inclusaocadastro;

import br.tec.email.emailapp.domain.entity.Cliente;

public interface InclusaoCadastro {
	
	Cliente cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException;
	
}
