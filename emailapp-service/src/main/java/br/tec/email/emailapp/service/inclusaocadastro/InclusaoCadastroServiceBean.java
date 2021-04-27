package br.tec.email.emailapp.service.inclusaocadastro;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.tec.email.emailapp.domain.hu.inclusaocadastro.ClienteJaCadastradoException;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.EnderecoClient;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.EnderecoNaoExistenteException;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.InclusaoCadastroHU;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.InclusaoCadastroRepository;
import br.tec.email.emailapp.integration.ViacepClient;
import br.tec.email.emailapp.persistence.dao.InclusaoCadastroDAO;
import br.tec.email.emailapp.service.dto.ClienteInclusaoDTO;
import br.tec.email.emailapp.service.mapper.ClienteMapper;

@Stateless
public class InclusaoCadastroServiceBean implements InclusaoCadastroService{

	static final String PERSISTENCE_UNIT = "br.tec.email.emailapp.pu";

	@PersistenceContext(unitName = PERSISTENCE_UNIT)
	private EntityManager entityManager;
	
	private EnderecoClient enderecoClient;
	private InclusaoCadastroRepository repositoryDAO;

	@Override
	public ClienteInclusaoDTO cadastrarCliente(ClienteInclusaoDTO cliente) throws ClienteJaCadastradoException, EnderecoNaoExistenteException {
		configurarRecursos();
		return ClienteMapper.toDTO(
					new InclusaoCadastroHU(repositoryDAO, enderecoClient).cadastrarCliente(ClienteMapper.fromDTO(cliente))
				);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public void configurarRecursos() {
		
		if(enderecoClient == null)
			enderecoClient = new ViacepClient();
		
		if(repositoryDAO == null)
			repositoryDAO = new InclusaoCadastroDAO(entityManager);	
		
	}

	public void setEnderecoClient(EnderecoClient enderecoClient) {
		this.enderecoClient = enderecoClient;
	}

	public void setRepositoryDAO(InclusaoCadastroRepository repositoryDAO) {
		this.repositoryDAO = repositoryDAO;
	}

}
