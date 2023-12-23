package br.com.dev.ecommerce.estoque.service;

import br.com.dev.ecommerce.estoque.dto.PedidoVendaDTO;

public interface PedidoVendaService {

	public PedidoVendaDTO buscar(Long id);		

	public void efetuar(PedidoVendaDTO pedidoVendaDTO);

	public void cancelar(Long id);
}
