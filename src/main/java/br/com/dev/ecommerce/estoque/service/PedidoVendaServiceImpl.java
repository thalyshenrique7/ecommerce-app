package br.com.dev.ecommerce.estoque.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.ecommerce.admin.terceiro.model.Terceiro;
import br.com.dev.ecommerce.admin.terceiro.repository.TerceiroRepository;
import br.com.dev.ecommerce.estoque.dto.PedidoVendaDTO;
import br.com.dev.ecommerce.estoque.exception.EstoqueException;
import br.com.dev.ecommerce.estoque.exception.NotFoundException;
import br.com.dev.ecommerce.estoque.mapper.PedidoVendaMapper;
import br.com.dev.ecommerce.estoque.model.PedidoVenda;
import br.com.dev.ecommerce.estoque.repository.PedidoVendaRepository;

@Service
public class PedidoVendaServiceImpl implements PedidoVendaService {

	@Autowired
	private PedidoVendaRepository pedidoRepository;

	@Autowired
	private TerceiroRepository terceiroRepository;
	
	@Autowired
	private PedidoVendaMapper mapper;

	@Override
	public PedidoVendaDTO buscar(Long id) {
		
		PedidoVenda pedidoVenda = this.pedidoRepository.findById(id).orElse(null);

		if (id == null)
			throw new NotFoundException("Pedido de venda não foi encontrado no sistema.");

		PedidoVendaDTO dto = this.mapper.toDTO(pedidoVenda);
		
		return dto;
	}

	@Override
	public void efetuar(PedidoVendaDTO pedidoVendaDTO) {

		Terceiro terceiro = this.terceiroRepository.findById(pedidoVendaDTO.getTerceiroId()).orElse(null);

		PedidoVenda pedido = new PedidoVenda();
		pedido.setValorTotal(pedidoVendaDTO.getValorTotal());
		pedido.setValorDesconto(pedidoVendaDTO.getValorDesconto());
		pedido.setProdutos(pedidoVendaDTO.getProdutos());
		pedido.setCancelado(pedidoVendaDTO.isCancelado());
		pedido.setTerceiro(terceiro);
		pedido.setDataCriacao(Calendar.getInstance());
		pedido.setDataAlteracao(Calendar.getInstance());

		try {

			pedidoRepository.save(pedido);

		} catch (Exception e) {
			throw new EstoqueException("Não foi possível efetuar o pedido de venda.");
		}

	}

	@Override
	public void cancelar(Long id) {

		PedidoVenda pedido = this.pedidoRepository.findById(id).orElse(null);

		if (id != null)
			pedido.setCancelado(true);
		else 
			throw new NotFoundException("Pedido de venda não foi encontrado no sistema.");

	}

}
