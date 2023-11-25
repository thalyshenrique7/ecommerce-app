package br.com.dev.ecommerce.estoque.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.admin.terceiro.model.Terceiro;
import br.com.dev.ecommerce.admin.terceiro.repository.TerceiroRepository;
import br.com.dev.ecommerce.estoque.dto.PedidoVendaDTO;
import br.com.dev.ecommerce.estoque.exception.EstoqueException;
import br.com.dev.ecommerce.estoque.exception.NotFoundException;
import br.com.dev.ecommerce.estoque.model.PedidoVenda;
import br.com.dev.ecommerce.estoque.repository.PedidoVendaRepository;

@Service
public class PedidoVendaServiceImpl implements PedidoVendaService {

	@Autowired
	private PedidoVendaRepository pedidoRepository;

	@Autowired
	private TerceiroRepository terceiroRepository;

	@Override
	public PedidoVenda buscar(Long id) {

		if (id == null)
			throw new NotFoundException("Pedido de venda não foi encontrado no sistema.");

		return pedidoRepository.findById(id).orElse(null);
	}

	@Override
	public void efetuar(PedidoVendaDTO pedidoVendaDTO) {

		if (pedidoVendaDTO != null) {

			Long terceiroId = pedidoVendaDTO.getTerceiroId();
			Terceiro terceiro = this.terceiroRepository.findById(terceiroId).orElse(null);

			PedidoVenda pedido = new PedidoVenda();

			pedido.setValorTotal(pedidoVendaDTO.getValorTotal());
			pedido.setValorDesconto(pedidoVendaDTO.getValorDesconto());
			pedido.setProdutos(pedidoVendaDTO.getProdutos());
			pedido.setCancelado(pedidoVendaDTO.isCancelado());
			pedido.setTerceiro(terceiro);
			pedido.setDataSaida(Calendar.getInstance());

			try {

				pedidoRepository.save(pedido);

			} catch (Exception e) {
				throw new EstoqueException("Não foi possível efetuar o pedido de venda.");
			}
		}

	}

	@Override
	public void cancelar(PedidoVenda pedidoVenda) {

		if (pedidoVenda != null) {

			try {

				pedidoVenda.setCancelado(true);

			} catch (Exception e) {
				throw new EstoqueException("Não foi possível cancelar o pedido de venda.");
			}
		}
	}

}
