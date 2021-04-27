package br.tec.email.emailapp.domain.hu.inclusaocadastro;

import br.tec.email.emailapp.domain.entity.Cliente;
import br.tec.email.emailapp.domain.entity.Endereco;

public class InclusaoCadastroHU implements InclusaoCadastro {

	private InclusaoCadastroRepository repository;
	private EnderecoClient enderecoClient;

	public InclusaoCadastroHU(
			InclusaoCadastroRepository repository,
			EnderecoClient enderecoClient) {
		this.repository = repository;
		this.enderecoClient = enderecoClient;
	}


	@Override
	public Cliente cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException, EnderecoNaoExistenteException{

		if(repository.clienteJaCadastrado(cliente)) {
			throw new ClienteJaCadastradoException();
		}else {
			Endereco enderecoCompleto = enderecoClient.getEnderecoCompleto(
					cliente.getEndereco().getCep());
			if(enderecoCompleto==null)
				throw new EnderecoNaoExistenteException();
			cliente.setEndereco(enderecoCompleto);
			return repository.cadastrarCliente(cliente);
		}

	}

}
