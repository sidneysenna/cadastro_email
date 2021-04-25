package br.tec.email.emailapp.service.inclusaocadastro;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.tec.email.emailapp.domain.hu.inclusaocadastro.InclusaoCadastroRepository;
import br.tec.email.emailapp.service.inclusaocadastro.dto.ClienteInclusaoDTO;
import br.tec.email.emailapp.service.inclusaocadastro.dto.mapper.ClienteMapper;

@Stateless
public class InclusaoCadastroServiceBean implements InclusaoCadastroService{

	@Inject
	InclusaoCadastroRepository repository;
	
	public InclusaoCadastroServiceBean(InclusaoCadastroRepository repository) {
		this.repository = repository;
	}

	@Override
	public ClienteInclusaoDTO cadastrarCliente(ClienteInclusaoDTO cliente) {
		return ClienteMapper.toDTO(repository.cadastrarCliente(ClienteMapper.fromDTO(cliente)));
	}

}
