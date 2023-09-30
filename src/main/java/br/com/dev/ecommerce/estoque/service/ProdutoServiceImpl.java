package br.com.dev.ecommerce.estoque.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.estoque.enums.Movimentacao;
import br.com.dev.ecommerce.estoque.exception.EstoqueException;
import br.com.dev.ecommerce.estoque.exception.NotFoundException;
import br.com.dev.ecommerce.estoque.mapper.ProdutoMapper;
import br.com.dev.ecommerce.estoque.model.Produto;
import br.com.dev.ecommerce.estoque.repository.ProdutoRepository;
import br.com.dev.ecommerce.estoque.repository.ProdutoRepositoryCustom;
import br.com.dev.ecommerce.utils.BigDecimalUtils;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoMapper produtoMapper;

	@Autowired
	private ProdutoRepositoryCustom produtoRepositoryCustom;

	@Override
	public Produto buscar(Long id) {

		Produto produtoId;

		try {

			produtoId = this.produtoRepository.findById(id).orElse(null);

		} catch (NotFoundException e) {
			throw new EstoqueException("Produto não encontrado no sistema.");
		}

		produtoMapper.setInformacoesProduto(produtoId);

		return produtoId;
	}

	@Override
	public void salvar(Produto produto) {

		if (produto != null) {

			if (BigDecimalUtils.isGreater(produto.getQuantidade(), BigDecimal.ZERO)) {

				/*
				 * Ao cadastrar um novo produto o tipo da movimentação deve ser Saldo Inicial
				 */
				produto.setMovimentacao(Movimentacao.SALDO_INICIAL);
				produto.setAtivo(true);

				try {

					this.produtoRepository.save(produto);

				} catch (EstoqueException e) {
					throw new EstoqueException("Saldo Inicial para o produto deve ser maior que 0.");
				}
			}
		}
	}

	@Override
	public void excluir(Produto produto) {

		this.produtoRepository.delete(produto);

	}

	@Transactional
	@Override
	public void atualizar(Long id, Produto produto) {

		if (produto != null) {

			if (!BigDecimalUtils.isLess(produto.getQuantidade(), BigDecimal.ZERO)) {

				produto.setId(id);

				try {

					this.produtoRepositoryCustom.merge(produto);

				} catch (EstoqueException e) {
					throw new EstoqueException("Saldo do produto não pode ser menor que 0.");
				}
			}
		}

		throw new NotFoundException("Produto não foi encontrado no sistema.");
	}

}
