package br.com.dev.ecommerce.estoque.repository;

import java.util.List;

import br.com.dev.ecommerce.estoque.dto.ProdutoDTO;
import br.com.dev.ecommerce.estoque.model.Produto;

public interface ProdutoRepositoryCustom {
	
	public ProdutoDTO getDTO(Long id);
	
	public void merge(ProdutoDTO dto);
	
	public List<Produto> getProdutos(); 
	
	public boolean verificarCodigoBarras(String codigoBarras, ProdutoDTO produto);

}
