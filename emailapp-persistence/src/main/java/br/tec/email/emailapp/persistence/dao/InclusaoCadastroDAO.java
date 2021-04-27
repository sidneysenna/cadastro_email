package br.tec.email.emailapp.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.tec.email.emailapp.domain.entity.Cliente;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.InclusaoCadastroRepository;
import br.tec.email.emailapp.persistence.dao.template.TemplateDAO;
import br.tec.email.emailapp.persistence.entity.ClienteEntity;
import br.tec.email.emailapp.persistence.entity.mapper.ClienteMapper;

public class InclusaoCadastroDAO extends TemplateDAO<Integer, ClienteEntity> implements InclusaoCadastroRepository{

	public InclusaoCadastroDAO(EntityManager entityManager) {
		super(ClienteEntity.class);
		this.setEntityManager(entityManager);
	}

	@Override
	public Cliente cadastrarCliente(Cliente cliente) {
		return ClienteMapper.fromEntity(this.gravar(ClienteMapper.toEntity(cliente)));
	}

	@Override
	public boolean clienteJaCadastrado(Cliente cliente) {
		Query q = getEntityManager().createQuery("Select c from ClienteEntity c where c.email = :email");
		q.setParameter("email", cliente.getEmail());
		try {
			q.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}	
	}


}
