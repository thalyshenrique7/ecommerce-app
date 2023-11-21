package br.com.dev.ecommerce.estoque.repository;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.util.Assert;

public class RepositoryCustomImpl {
	
	protected final Session getSession(EntityManager em) {
		
		return em.unwrap(Session.class);
	}
	
	@SuppressWarnings("deprecation")
	protected final Criteria createCriteria(EntityManager em, Class<?> clazz) {
		
		return this.getSession(em).createCriteria(clazz);
	}
	
	/*
	 * Retorna a quantidade de registros na consulta
	 */
	protected final int rowCount(Criteria query) {
		
		Assert.notNull(query, "criteria");
		
		query.setProjection(Projections.rowCount());
		Object rc = query.uniqueResult();
		
		Assert.notNull(rc, "rowCount");
		
		query.setProjection(null);
		query.setResultTransformer(Criteria.ROOT_ENTITY);
		
		try {
			return Integer.parseInt(rc.toString());
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao tentar obter quantidade de registros da consulta.", e);
		}
	}

}
