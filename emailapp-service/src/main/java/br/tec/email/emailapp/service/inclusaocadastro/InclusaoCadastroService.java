package br.tec.email.emailapp.service.inclusaocadastro;

import br.tec.email.emailapp.domain.hu.inclusaocadastro.ClienteJaCadastradoException;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.EnderecoNaoExistenteException;
import br.tec.email.emailapp.service.dto.ClienteInclusaoDTO;

public interface InclusaoCadastroService {
	
	ClienteInclusaoDTO cadastrarCliente(ClienteInclusaoDTO cliente) throws ClienteJaCadastradoException, EnderecoNaoExistenteException;

}
