package br.com.dev.ecommerce.estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.estoque.dto.ProdutoDTO;
import br.com.dev.ecommerce.estoque.exception.EstoqueException;
import br.com.dev.ecommerce.estoque.exception.NotFoundException;
import br.com.dev.ecommerce.estoque.mapper.ProdutoMapper;
import br.com.dev.ecommerce.estoque.model.Produto;
import br.com.dev.ecommerce.estoque.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoMapper produtoMapper;

	@Override
	public ProdutoDTO buscar(Long id) {

		Produto produtoId;

		try {

			produtoId = this.produtoRepository.findById(id).orElse(null);

		} catch (NotFoundException e) {
			throw new EstoqueException("Produto não encontrado no sistema.");
		}

		ProdutoDTO dto = produtoMapper.setInformacoesProduto(produtoId);

		return dto;
	}

	@Override
	public void salvar(Produto produto) {

		if (produto != null) {

			try {

				this.produtoRepository.save(produto);

			} catch (Exception e) {
				throw e;
			}

		}

	}

}
