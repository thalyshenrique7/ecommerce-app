package br.com.dev.ecommerce.estoque.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.estoque.dto.ProdutoDTO;
import br.com.dev.ecommerce.estoque.dto.ProdutoDetalheDTO;
import br.com.dev.ecommerce.estoque.enums.Movimentacao;
import br.com.dev.ecommerce.estoque.exception.EstoqueException;
import br.com.dev.ecommerce.estoque.mapper.ProdutoMapper;
import br.com.dev.ecommerce.estoque.model.Produto;
import br.com.dev.ecommerce.estoque.repository.ProdutoRepository;
import br.com.dev.ecommerce.utils.number.BigDecimalUtils;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoMapper produtoMapper;

	@Override
	public ProdutoDetalheDTO buscar(Long id) {

		Produto produtoId;

		produtoId = this.produtoRepository.findById(id).orElse(null);

		ProdutoDetalheDTO dto = produtoMapper.toDetalheDTO(produtoId);

		return dto;
	}

	@Override
	public void salvar(ProdutoDTO dto) {

		Produto produto = null;

		if (dto != null && BigDecimalUtils.isGreaterThan(dto.getQuantidade(), BigDecimal.ZERO)) {

			/*
			 * Ao cadastrar um novo produto o tipo da movimentação deve ser Saldo Inicial
			 */
			dto.setMovimentacao(Movimentacao.SALDO_INICIAL);
			dto.setAtivo(true);
			dto.setDataCriacao(Calendar.getInstance());
			dto.setDataAlteracao(Calendar.getInstance());

			if (this.produtoRepository.verificarCodigoBarras(dto.getCodigoBarras(), dto))
				throw new EstoqueException("Ocorreu um erro ao tentar salvar o produto. Código de barras já existe.");

			produto = this.produtoMapper.toEntity(dto);

			try {

				this.getRepository().save(produto);

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

				dto = this.getRepository().getDTO(id);

			} catch (Exception e) {
				throw new RuntimeException("Produto não foi encontrado no sistema.", e);
			}

		}

		Produto produto = this.produtoMapper.toEntity(dto);

		this.produtoRepository.delete(produto);
	}

	@Transactional
	@Override
	public void atualizar(Long id, ProdutoDTO dto) {

		if (id != null && !BigDecimalUtils.isLessThan(dto.getQuantidade(), BigDecimal.ZERO)) {

			dto.setId(id);
			dto.setDataAlteracao(Calendar.getInstance());
		}

		this.getRepository().merge(dto);
	}

	@Override
	public List<ProdutoDetalheDTO> getProdutos() {

		List<Produto> produtos = this.getRepository().getProdutos();

		List<ProdutoDetalheDTO> dtos = this.produtoMapper.toDTOs(produtos);

		return dtos;
	}

	private ProdutoRepository getRepository() {

		return (ProdutoRepository) this.produtoRepository;
	}

}
