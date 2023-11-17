package br.com.dev.ecommerce.estoque.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.dev.ecommerce.estoque.model.Produto;

public class PedidoVendaDTO {

	private BigDecimal valorTotal;

	private BigDecimal valorDesconto;

	private List<Produto> produtos;

	private boolean cancelado;

	private Long terceiroId;

	private String terceiroNome;

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public List<Produto> getProdutos() {

		if (produtos == null)
			produtos = new ArrayList<>();

		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public Long getTerceiroId() {
		return terceiroId;
	}

	public void setTerceiroId(Long terceiroId) {
		this.terceiroId = terceiroId;
	}

	public String getTerceiroNome() {
		return terceiroNome;
	}

	public void setTerceiroNome(String terceiroNome) {
		this.terceiroNome = terceiroNome;
	}

}
