package br.com.dev.ecommerce.estoque.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.util.Assert;

import br.com.dev.ecommerce.estoque.model.Produto;

public class ProdutoRepositoryImpl extends RepositoryCustomImpl implements ProdutoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Produto getProduto(Long id) {
		
		Assert.notNull(id, "É obrigatório passar um ID válido para realizar a busca.");
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append("    	 PRODUTO.ID ");
		sb.append("    , PRODUTO.NOME ");
		sb.append("    , PRODUTO.NCM ");
		sb.append("    , PRODUTO.CODIGOBARRAS ");
		sb.append(" FROM PRODUTO PRODUTO ");
		sb.append(" ORDER BY PRODUTO.ID DESC ");
		
		TypedQuery<Produto> query = em.createQuery(sb.toString(), Produto.class);
		query.setParameter("produtoId", id);
		
		try {
			
			return query.getSingleResult();
			
		} catch (NoResultException e) {
			throw e;
		}
	}

}
