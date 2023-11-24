package br.com.dev.ecommerce.estoque.dto;

import java.math.BigDecimal;

public class ProdutoDetalheDTO {

	private String nome;

	private String ncm;

	private String codigoBarras;

	private BigDecimal precoCusto;

	private BigDecimal precoVenda;

	private String movimentacaoDescricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getMovimentacaoDescricao() {
		return movimentacaoDescricao;
	}

	public void setMovimentacaoDescricao(String movimentacaoDescricao) {
		this.movimentacaoDescricao = movimentacaoDescricao;
	}

}
