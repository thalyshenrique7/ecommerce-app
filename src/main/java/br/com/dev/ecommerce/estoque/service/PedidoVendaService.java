package br.com.dev.ecommerce.estoque.service;

import br.com.dev.ecommerce.estoque.model.PedidoVenda;

public interface PedidoVendaService {

	public PedidoVenda buscar(Long id);

	public void efetuar(PedidoVenda pedidoVenda);

	public void cancelar(PedidoVenda pedidoVenda);
}
