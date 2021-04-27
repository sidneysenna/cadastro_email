package br.tec.email.emailapp.domain.hu.inclusaocadastro;

import br.tec.email.emailapp.domain.entity.Cliente;

public interface InclusaoCadastroRepository {
	
	Cliente cadastrarCliente(Cliente cliente);
	
	boolean clienteJaCadastrado(Cliente cliente);
	
	
	
	

}
