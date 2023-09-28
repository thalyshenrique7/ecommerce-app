package br.com.dev.ecommerce.estoque.repository;

import br.com.dev.ecommerce.estoque.model.Produto;

public interface ProdutoRepositoryCustom {
	
	public Produto getProduto(Long id);

}
