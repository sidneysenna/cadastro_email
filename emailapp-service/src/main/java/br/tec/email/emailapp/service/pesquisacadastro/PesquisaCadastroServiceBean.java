package br.tec.email.emailapp.service.pesquisacadastro;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.tec.email.emailapp.domain.hu.pesquisarcadastro.EmailNaoInformadoException;
import br.tec.email.emailapp.domain.hu.pesquisarcadastro.PesquisarCadastro;
import br.tec.email.emailapp.domain.hu.pesquisarcadastro.PesquisarCadastroHU;
import br.tec.email.emailapp.domain.hu.pesquisarcadastro.PesquisarCadastroRepository;
import br.tec.email.emailapp.persistence.dao.PesquisaCadastroDAO;
import br.tec.email.emailapp.service.EmailappException;
import br.tec.email.emailapp.service.dto.ClienteInclusaoDTO;

@Stateless
public class PesquisaCadastroServiceBean implements PesquisaCadastroService {
	
	final String PERSISTENCE_UNIT = "br.tec.email.emailapp.pu";

	@PersistenceContext(unitName = PERSISTENCE_UNIT)
	private EntityManager entityManager;

	public PesquisaCadastroServiceBean() {
	}

	@Override
	public ClienteInclusaoDTO pesquisarCadastro(String email) {
		PesquisarCadastroRepository repositoryDAO = new PesquisaCadastroDAO(entityManager);			
		PesquisarCadastro pesquisarCadastroHU = new PesquisarCadastroHU(repositoryDAO);
		
		try {
			return br.tec.email.emailapp.service.mapper.ClienteMapper.toDTO(pesquisarCadastroHU.buscarCadastroPorEmail(email));
		} catch (EmailNaoInformadoException e) {
			throw new EmailappException("E-mail nao informado");
		}
	}
	
		
	
	
	

}
