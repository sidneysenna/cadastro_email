package br.tec.email.emailapp.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.tec.email.emailapp.domain.entity.Cliente;
import br.tec.email.emailapp.domain.hu.pesquisarcadastro.PesquisarCadastroRepository;
import br.tec.email.emailapp.persistence.dao.template.TemplateDAO;
import br.tec.email.emailapp.persistence.entity.ClienteEntity;
import br.tec.email.emailapp.persistence.entity.mapper.ClienteMapper;

public class PesquisaCadastroDAO extends TemplateDAO<Integer, ClienteEntity> implements PesquisarCadastroRepository{

	public PesquisaCadastroDAO(EntityManager entityManager) {
		super(ClienteEntity.class);
		this.setEntityManager(entityManager);
	}

	@Override
	public Cliente buscarCadastroPorEmail(String email) {
		TypedQuery<ClienteEntity> q = getEntityManager().createQuery("Select c from ClienteEntity c where c.email = :email", ClienteEntity.class);
		q.setParameter("email", email);
		
		return ClienteMapper.fromEntity(q.getSingleResult());
		
		
	}

}
