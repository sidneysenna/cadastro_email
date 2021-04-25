package br.tec.email.emailapp.service.inclusaocadastro;

import javax.ejb.Stateless;

import br.tec.email.emailapp.service.inclusaocadastro.dto.ClienteInclusaoDTO;

@Stateless
public class InclusaoCadastroServiceBean implements InclusaoCadastroService{

	public InclusaoCadastroServiceBean() {
	}

	@Override
	public ClienteInclusaoDTO cadastrarCliente(ClienteInclusaoDTO cliente) {
		throw new InclusaoCadastroException();
	}

}
