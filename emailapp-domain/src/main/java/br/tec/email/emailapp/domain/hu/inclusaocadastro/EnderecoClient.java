package br.tec.email.emailapp.domain.hu.inclusaocadastro;

import br.tec.email.emailapp.domain.entity.Endereco;

public interface EnderecoClient {
	
	Endereco getEnderecoCompleto(String cep) throws EnderecoNaoExistenteException;

}
