package br.com.dev.ecommerce.estoque.service;

import java.util.List;

import br.com.dev.ecommerce.estoque.dto.ProdutoDTO;
import br.com.dev.ecommerce.estoque.dto.ProdutoDetalheDTO;

public interface ProdutoService {
	
	public ProdutoDetalheDTO buscar(Long id);		
	
	public void salvar(ProdutoDTO dto);
	
	public void excluir(Long id);
	
	public void atualizar(Long id, ProdutoDTO dto);
	
	public List<ProdutoDetalheDTO> getProdutos();

}
