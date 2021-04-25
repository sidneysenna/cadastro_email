package br.tec.email.emailapp.service.inclusaocadastro;

import br.tec.email.emailapp.service.inclusaocadastro.dto.ClienteInclusaoDTO;

public interface InclusaoCadastroService {
	
	ClienteInclusaoDTO cadastrarCliente(ClienteInclusaoDTO cliente);

}
