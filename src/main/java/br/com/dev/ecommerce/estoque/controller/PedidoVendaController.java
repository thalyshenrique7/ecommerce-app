package br.com.dev.ecommerce.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.ecommerce.estoque.dto.PedidoVendaDTO;
import br.com.dev.ecommerce.estoque.exception.NotFoundException;
import br.com.dev.ecommerce.estoque.service.PedidoVendaServiceImpl;

@RestController
@RequestMapping(value = "/api/pedido-venda", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public class PedidoVendaController {

	@Autowired
	private PedidoVendaServiceImpl pedidoService;

	@GetMapping(value = "/buscar/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PedidoVendaDTO> buscar(@PathVariable(value = "id") Long id) throws NotFoundException {

		return ResponseEntity.status(HttpStatus.OK).body(pedidoService.buscar(id));
	}

	@PostMapping(value = "/efetuar")
	@ResponseStatus(HttpStatus.CREATED)
	public void efetuar(@RequestBody PedidoVendaDTO pedidoDTO) throws NotFoundException {

		pedidoService.efetuar(pedidoDTO);
	}

	@DeleteMapping(value = "/cancelar/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void cancelar(@PathVariable(value = "id") Long id) throws NotFoundException {

		pedidoService.cancelar(id);
	}
}
