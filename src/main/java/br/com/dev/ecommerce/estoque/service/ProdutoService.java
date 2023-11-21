package br.com.dev.ecommerce.estoque.service;

import java.util.List;

import br.com.dev.ecommerce.estoque.model.Produto;

public interface ProdutoService {
	
	public Produto buscar(Long id);
	
	public void salvar(Produto produto);
	
	public void excluir(Produto produto);
	
	public void atualizar(Long id, Produto produto);
	
	public List<Produto> getProdutos();

}
