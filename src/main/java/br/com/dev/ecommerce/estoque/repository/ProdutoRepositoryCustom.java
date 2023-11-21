package br.com.dev.ecommerce.estoque.repository;

import java.util.List;

import br.com.dev.ecommerce.estoque.model.Produto;

public interface ProdutoRepositoryCustom {
	
	public void merge(Produto produto);
	
	public List<Produto> getProdutos(); 
	
	public boolean verificarCodigoBarras(String codigoBarras, Produto produto);

}
