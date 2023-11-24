package br.com.dev.ecommerce.estoque.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.dev.ecommerce.estoque.dto.ProdutoDTO;
import br.com.dev.ecommerce.estoque.model.Produto;

public class ProdutoRepositoryImpl extends RepositoryCustomImpl implements ProdutoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void merge(ProdutoDTO produto) {

		if (produto.getId() == null)
			em.persist(produto);

		em.merge(produto);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Produto> getProdutos() {

		Criteria query = this.getSession(em).createCriteria(Produto.class);

		return query.list();
	}

	@Override
	public boolean verificarCodigoBarras(String codigoBarras, ProdutoDTO produto) {

		@SuppressWarnings("deprecation")
		Criteria query = this.getSession(em).createCriteria(Produto.class);

		query.add(Restrictions.eq("codigoBarras", codigoBarras));

		if (produto.getId() != null) {
			query.add(Restrictions.ne("id", produto.getId()));
		}

		int totalCount = this.rowCount(query);

		return totalCount > 0;
	}

	@Override
	public ProdutoDTO getDTO(Long id) {

		Produto produto = em.find(Produto.class, id);

		ProdutoDTO dto = null;

		if (produto != null) {

			dto = new ProdutoDTO();
			dto.setId(produto.getId());
		}

		return dto;
	}

}
