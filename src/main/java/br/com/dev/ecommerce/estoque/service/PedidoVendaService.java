package br.com.dev.ecommerce.estoque.service;

import br.com.dev.ecommerce.estoque.dto.PedidoVendaDTO;
import br.com.dev.ecommerce.estoque.exception.NotFoundException;

public interface PedidoVendaService {

	public PedidoVendaDTO buscar(Long id) throws NotFoundException;		

	public void efetuar(PedidoVendaDTO pedidoVendaDTO) throws NotFoundException;

	public void cancelar(Long id) throws NotFoundException;
}
