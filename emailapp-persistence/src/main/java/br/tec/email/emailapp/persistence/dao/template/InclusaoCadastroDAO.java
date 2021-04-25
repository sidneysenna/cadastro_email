package br.tec.email.emailapp.persistence.dao.template;

import javax.persistence.Query;

import br.tec.email.emailapp.domain.entity.Cliente;
import br.tec.email.emailapp.domain.hu.inclusaocadastro.InclusaoCadastroRepository;
import br.tec.email.emailapp.persistence.entity.ClienteEntity;
import br.tec.email.emailapp.persistence.entity.mapper.ClienteMapper;

public class InclusaoCadastroDAO extends TemplateDAO<Integer, ClienteEntity> implements InclusaoCadastroRepository{

	public InclusaoCadastroDAO() {
		super(ClienteEntity.class);
	}

	@Override
	public Cliente cadastrarCliente(Cliente cliente) {
		return ClienteMapper.fromEntity(this.gravar(ClienteMapper.toEntity(cliente)));
	}

	@Override
	public boolean clienteJaCadastrado(Cliente cliente) {
		
		Query q = getEntityManager().createQuery("Select c from ClienteEntity c where c.cpf = :cpf");
		q.setParameter("cpf", cliente.getCpf());
		
		return q.getMaxResults() > 0;		

	}
	
	

}
