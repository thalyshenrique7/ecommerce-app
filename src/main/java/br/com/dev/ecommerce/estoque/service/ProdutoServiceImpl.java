package br.com.dev.ecommerce.estoque.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.estoque.dto.ProdutoDTO;
import br.com.dev.ecommerce.estoque.enums.Movimentacao;
import br.com.dev.ecommerce.estoque.exception.EstoqueException;
import br.com.dev.ecommerce.estoque.exception.NotFoundException;
import br.com.dev.ecommerce.estoque.mapper.ProdutoMapper;
import br.com.dev.ecommerce.estoque.model.Produto;
import br.com.dev.ecommerce.estoque.repository.ProdutoRepository;
import br.com.dev.ecommerce.utils.BigDecimalUtils;

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

		ProdutoDTO dto = produtoMapper.toDTO(produtoId);

		return dto;
	}

	@Override
	public void salvar(Produto produto) {

		if (produto != null && BigDecimalUtils.isGreater(produto.getQuantidade(), BigDecimal.ZERO)) {

			/*
			 * Ao cadastrar um novo produto o tipo da movimentação deve ser Saldo Inicial
			 */
			produto.setMovimentacao(Movimentacao.SALDO_INICIAL);
			produto.setAtivo(true);
			produto.setDataCriacao(Calendar.getInstance());
			produto.setDataAlteracao(Calendar.getInstance());

			if (this.produtoRepository.verificarCodigoBarras(produto.getCodigoBarras(), produto))
				throw new EstoqueException("Ocorreu um erro ao tentar salvar o produto. Código de barras já existe.");

			try {

				this.produtoRepository.save(produto);

			} catch (EstoqueException e) {
				throw new EstoqueException("Saldo Inicial para o produto deve ser maior que 0.");
			}

		}
	}

	@Override
	public void excluir(Long id) {
		
		ProdutoDTO dto = null;
		
		if (id != null) {
			
			try {
				
				dto = this.buscar(id);
				
			} catch (Exception e) {
				throw new RuntimeException("Produto não foi encontrado no sistema.", e);
			}
			
		}
		
		Produto produto = this.produtoMapper.toEntity(dto);

		this.produtoRepository.delete(produto);

	}

	@Transactional
	@Override
	public void atualizar(Long id, Produto produto) {

		if (id != null && !BigDecimalUtils.isLess(produto.getQuantidade(), BigDecimal.ZERO)) {

			produto.setId(id);
			produto.setDataAlteracao(Calendar.getInstance());
		}

		try {

			this.getRepository().merge(produto);

		} catch (NotFoundException e) {
			throw new EstoqueException("Ocorreu um problema ao tentar salvar o produto.");
		}
	}

	@Override
	public List<ProdutoDTO> getProdutos() {

		List<Produto> produtos = this.getRepository().getProdutos();

		List<ProdutoDTO> dtos = this.produtoMapper.toDTOs(produtos);

		return dtos;
	}

	private ProdutoRepository getRepository() {

		return (ProdutoRepository) this.produtoRepository;
	}

}
