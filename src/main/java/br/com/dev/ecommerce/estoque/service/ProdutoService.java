package br.com.dev.ecommerce.estoque.service;

import java.util.List;

import br.com.dev.ecommerce.estoque.dto.ProdutoDTO;
import br.com.dev.ecommerce.estoque.model.Produto;

public interface ProdutoService {
	
	public ProdutoDTO buscar(Long id);		
	
	public void salvar(Produto produto);
	
	public void excluir(Long id);
	
	public void atualizar(Long id, Produto produto);
	
	public List<ProdutoDTO> getProdutos();

}
