package br.tec.email.emailapp.persistence.dao.template;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.tec.email.emailapp.persistence.entity.template.TemplateEntity;

public abstract class TemplateDAO <K extends Serializable, T extends TemplateEntity<K>>{
	
	protected static final String AND = " AND ";
	protected static final String OR = " OR ";

	private EntityManager entityManager;

	private Class<T> clazz;

	public TemplateDAO(Class<T> clazz) {
		this.clazz = clazz;
	}

	public List<T> listar() {
		CriteriaQuery<T> q = getCriteriaBuilder().createQuery(clazz);
		Root<T> c = q.from(clazz);				
		return entityManager.createQuery(q.select(c)).getResultList();
	}

	public T consultarPorId(K id) {
		return entityManager.find(clazz, id);
	}

	public T gravar(T objeto) {
		if (objeto.getId() == null) {
			entityManager.persist(objeto);
			return objeto;
		}

		return entityManager.merge(objeto);
	}

	public void excluir(K id) {
		T objeto = consultarPorId(id);
		excluir(objeto);
	}

	public void excluir(T objeto) {
		entityManager.remove(objeto);
	}

	protected CriteriaBuilder getCriteriaBuilder() {
		return entityManager.getCriteriaBuilder();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


}
