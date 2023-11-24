package br.com.dev.ecommerce.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.ecommerce.estoque.dto.ProdutoDTO;
import br.com.dev.ecommerce.estoque.dto.ProdutoDetalheDTO;
import br.com.dev.ecommerce.estoque.service.ProdutoServiceImpl;

@RestController
@RequestMapping(value = "/api/produto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

	@Autowired
	private ProdutoServiceImpl produtoService;

	@GetMapping(value = "{id}")
	public ResponseEntity<ProdutoDetalheDTO> buscar(@PathVariable(value = "id") Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.buscar(id));
	}

	@PostMapping(value = "/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody ProdutoDTO produto) {

		this.produtoService.salvar(produto);
	}

	@DeleteMapping(value = "/excluir/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void excluir(@PathVariable(value = "id") Long id) {

		this.produtoService.excluir(id);
	}

	@PutMapping(value = "/atualizar/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void atualizar(@PathVariable(value = "id") Long id, @RequestBody ProdutoDTO produto) {

		this.produtoService.atualizar(id, produto);
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDetalheDTO>> getProdutos() {

		return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.getProdutos());
	}
}
