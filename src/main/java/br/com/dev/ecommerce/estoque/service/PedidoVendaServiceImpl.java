package br.com.dev.ecommerce.estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.estoque.exception.EstoqueException;
import br.com.dev.ecommerce.estoque.exception.NotFoundException;
import br.com.dev.ecommerce.estoque.model.PedidoVenda;
import br.com.dev.ecommerce.estoque.repository.PedidoVendaRepository;

@Service
public class PedidoVendaServiceImpl implements PedidoVendaService {

	@Autowired
	private PedidoVendaRepository pedidoRepository;

	@Override
	public PedidoVenda buscar(Long id) {

		if (id == null)
			throw new NotFoundException("Pedido de venda não foi encontrado no sistema.");

		return pedidoRepository.findById(id).orElse(null);
	}

	@Override
	public void efetuar(PedidoVenda pedidoVenda) {
		
		if (pedidoVenda != null) {
			
			try {
				
				pedidoRepository.save(pedidoVenda);
				
			} catch (Exception e) {
				throw new EstoqueException("Não foi possível efetuar o pedido de venda.");
			}
		}

	}

	@Override
	public void cancelar(PedidoVenda pedidoVenda) {
		
		if (pedidoVenda != null) {
			
			try {
				
				pedidoRepository.delete(pedidoVenda);
				
			} catch (Exception e) {
				throw new EstoqueException("Não foi possível cancelar o pedido de venda.");
			}
		}
	}

}
