package br.com.dev.ecommerce.estoque.service;

import br.com.dev.ecommerce.estoque.dto.ProdutoDTO;
import br.com.dev.ecommerce.estoque.model.Produto;

public interface ProdutoService {
	
	public ProdutoDTO buscar(Long id);
	
	public void salvar(Produto produto);

}
