package br.tec.email.emailapp.service.pesquisacadastro;

import br.tec.email.emailapp.service.dto.ClienteInclusaoDTO;

public interface PesquisaCadastroService {
	
	ClienteInclusaoDTO pesquisarCadastro(String email);

}
