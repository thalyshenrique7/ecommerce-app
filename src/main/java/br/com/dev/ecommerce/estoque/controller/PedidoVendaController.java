package br.com.dev.ecommerce.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.ecommerce.estoque.dto.PedidoVendaDTO;
import br.com.dev.ecommerce.estoque.model.PedidoVenda;
import br.com.dev.ecommerce.estoque.service.PedidoVendaServiceImpl;

@RestController
@RequestMapping(value = "/api/pedido-venda")
public class PedidoVendaController {

	@Autowired
	private PedidoVendaServiceImpl pedidoService;

	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public PedidoVenda buscar(@PathVariable(value = "id") Long id) {

		return pedidoService.buscar(id);
	}

	@RequestMapping(value = "/efetuar", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void efetuar(@RequestBody PedidoVendaDTO pedidoDTO) {

		pedidoService.efetuar(pedidoDTO);
	}

	@RequestMapping(value = "/cancelar/{id}", method = RequestMethod.DELETE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void cancelar(@PathVariable(value = "id") Long id) {

		PedidoVenda pedido = this.pedidoService.buscar(id);

		pedidoService.cancelar(pedido);
	}
}
