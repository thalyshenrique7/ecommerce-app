package br.com.dev.ecommerce.estoque.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dev.ecommerce.estoque.model.Produto;

public class ProdutoRepositoryImpl extends RepositoryCustomImpl implements ProdutoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void merge(Produto produto) {

		em.merge(produto);
	}

}
