package br.com.dev.ecommerce.estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.estoque.dto.ProdutoDTO;
import br.com.dev.ecommerce.estoque.enums.Movimentacao;
import br.com.dev.ecommerce.estoque.exception.EstoqueException;
import br.com.dev.ecommerce.estoque.exception.NotFoundException;
import br.com.dev.ecommerce.estoque.mapper.ProdutoMapper;
import br.com.dev.ecommerce.estoque.model.Produto;
import br.com.dev.ecommerce.estoque.repository.ProdutoRepository;
import br.com.dev.ecommerce.estoque.repository.ProdutoRepositoryCustom;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoMapper produtoMapper;
	
	@Autowired
	private ProdutoRepositoryCustom produtoRepositoryCustom;

	@Override
	public ProdutoDTO buscar(Long id) {

		Produto produtoId;

		try {

			produtoId = this.produtoRepositoryCustom.getProduto(id);

		} catch (NotFoundException e) {
			throw new EstoqueException("Produto não encontrado no sistema.");
		}

		ProdutoDTO dto = produtoMapper.setInformacoesProduto(produtoId);

		return dto;
	}

	@Override
	public void salvar(Produto produto) {

		if (produto != null) {

			/*
			 * Ao cadastrar um novo produto o tipo da movimentação deve ser Saldo Inicial
			 */
			produto.setMovimentacao(Movimentacao.SALDO_INICIAL);

			try {

				this.produtoRepository.save(produto);

			} catch (Exception e) {
				throw e;
			}
		}
	}

}
